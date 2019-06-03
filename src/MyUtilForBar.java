import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * 自定义按钮
 */
class ToolbarButton extends JButton {
    ToolbarButton(String text, int width, int heigth, ActionListener l) {
        this.setText(text);
        addActionListener(l);
        this.setFont(new Font("宋体", Font.BOLD, 30));
        // 按钮大小设置
        setPreferredSize(new Dimension(width, heigth));
    }

    ToolbarButton(String text, int width, int heigth) {
        this.setText(text);
        this.setFont(new Font("宋体", Font.BOLD, 30));
        // 按钮大小设置
        setPreferredSize(new Dimension(width, heigth));
    }
}

/**
 * 自定义显示框，加个按钮
 */
class textAreaRes extends JToolBar {
    JTextArea textArea = new JTextArea();
    ToolbarButton butRes;

    textAreaRes() {
        butRes = new ToolbarButton("结果", 100, 100);
        textArea.setFont(new Font("宋体", Font.BOLD, 30));
        this.add(textArea);

        JToolBar sonToolBar = new JToolBar();
        sonToolBar.add(butRes);
        sonToolBar.setFloatable(false);
        sonToolBar.setOrientation(VERTICAL);
        this.add(sonToolBar);

        this.setFloatable(false);
    }

    textAreaRes(String butStr) {
        butRes = new ToolbarButton(butStr, 100, 100);
        textArea.setFont(new Font("宋体", Font.BOLD, 30));
        this.add(textArea);

        JToolBar sonToolBar = new JToolBar();
        sonToolBar.add(butRes);
        sonToolBar.setFloatable(false);
        sonToolBar.setOrientation(VERTICAL);
        this.add(sonToolBar);

        this.setFloatable(false);
    }
}