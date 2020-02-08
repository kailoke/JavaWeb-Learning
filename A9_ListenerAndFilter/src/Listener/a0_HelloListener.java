package Listener;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/** 监听器的执行过程
 * 1、主动绑定：事件源的对象，主动绑定监听器对象
 * 2、特定操作创建 "事件对象"(获取事件源对象)
 * 3、"事件对象"触发(传递至)监听器对象执行方法
 */

// 事件源
public class a0_HelloListener extends JFrame {
    public static void main(String[] args) {
        // 1.创建窗口对象
        a0_HelloListener frame = new a0_HelloListener();
        // 2.设置窗口显示
        frame.setName("小窗口");
        frame.setBounds(1000,500,300,200);
        frame.setVisible(true);

        // 3.在事件源注册监听器
        frame.addWindowListener(new HelloListener());
    }
}
// 监听器
class HelloListener implements WindowListener{

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    // WindowEvent 事件对象
    public void windowClosing(WindowEvent e) {
        System.out.println("windowClosing");
        a0_HelloListener source = (a0_HelloListener)e.getSource();
        System.out.println(source.getName());
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
