package com.zhoujixing.wechat.smq;

import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinUser;

public class ScanBarcodeService {
    private WinUser.HHOOK hhook;
    private final User32 lib = User32.INSTANCE;

    /**
     * 停止扫码枪服务
     */
    public void stopScanBarcodeService() {
        lib.UnhookWindowsHookEx(hhook);
    }

    /**
     * 启动扫描枪服务
     */
    public void startScanBarcodeService() {
        //键盘事件监听
        final BarcodeKeyboardListener listener = new BarcodeKeyboardListener();
        //回调
        WinUser.LowLevelKeyboardProc keyboardHook = new WinUser.LowLevelKeyboardProc() {
            @Override
            public WinDef.LRESULT callback(int i, WinDef.WPARAM wparam, WinUser.KBDLLHOOKSTRUCT kbdllhookstruct) {
                if (i >= 0){
                    switch (wparam.intValue()){
                        case WinUser.WM_KEYUP :
                            int keyCode = kbdllhookstruct.vkCode;
                            //监听数字键0-9
                            if (keyCode >=48 && keyCode <= 57){
                                listener.onKey(keyCode);
                            }
                            if (keyCode == 13){
                                //交给监听器处理
                                listener.onKey(keyCode);
                            }
                            break;
                    }
                }
                return lib.CallNextHookEx(hhook,i,wparam,kbdllhookstruct.getPointer());
            }
        };
        WinDef.HMODULE hmodule = Kernel32.INSTANCE.GetModuleHandle(null);
        //将上面定义的 回调方法 安装到挂钩链中对系统的底层的键盘输入事件进行监控
        hhook = lib.SetWindowsHookEx(WinUser.WH_KEYBOARD_LL,keyboardHook,hmodule,0);
        //处理消息（线程阻塞）
        int result;
        WinUser.MSG msg = new WinUser.MSG();
        while ((result = lib.GetMessage(msg,null,0,0)) != 0){
            if (result == 1){
                System.out.println("获取消息失败");
                break;
            }else {
                lib.TranslateMessage(msg);
                lib.DispatchMessage(msg);
            }
        }
    }
}
