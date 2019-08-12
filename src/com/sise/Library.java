package com.sise;

import java.awt.BorderLayout;
import java.awt.Dimension;
//import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

import com.sise.iframe.BookLoginIFrame;
import com.sise.util.CreatecdIcon;;

/**
 * ������
 * 
 */
public class Library extends JFrame {
	private static final JDesktopPane DESKTOP_PANE = new JDesktopPane();
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager
					.getSystemLookAndFeelClassName());
			new BookLoginIFrame();//��¼����
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public static void addIFame(JInternalFrame iframe) { // ����Ӵ���
		DESKTOP_PANE.add(iframe);
	}
	public Library() {
		super();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		setLocationByPlatform(true);
		setSize(800, 600);
		setTitle("ͼ��ݹ���ϵͳ");
		JMenuBar menuBar = createMenu(); // ���ô����˵����ķ���
		setJMenuBar(menuBar);
		JToolBar toolBar = createToolBar(); // ���ô����������ķ���
		getContentPane().add(toolBar, BorderLayout.NORTH);
		final JLabel label = new JLabel();
		label.setBounds(0, 0, 0, 0);
		label.setIcon(null); // ���屳��

		DESKTOP_PANE.addComponentListener(new ComponentAdapter() {
			public void componentResized(final ComponentEvent e) {
				Dimension size = e.getComponent().getSize();
				label.setSize(e.getComponent().getSize());
				label.setText("<html><img width=" + size.width + " height="
						+ size.height + " src='"
						+ this.getClass().getResource("/backImg.jpg")
						+ "'></html>");
			}
		});
		DESKTOP_PANE.add(label,new Integer(Integer.MIN_VALUE));
		getContentPane().add(DESKTOP_PANE);
	}
	/**
	 * ����������
	 * 
	 * @return JToolBar
	 */
	private JToolBar createToolBar() { // �����������ķ���
		JToolBar toolBar = new JToolBar();
		return toolBar;}

		
	/**
	 * �����˵���
	 */
	private JMenuBar createMenu() { // �����˵����ķ���
		JMenuBar menuBar = new JMenuBar();

		JMenu bookOrderMenu = new JMenu("���鶩������"); // ��ʼ��ͼ�����˵�
		
		bookOrderMenu.add(MenuActions.NEWBOOK_ORDER);
		bookOrderMenu.add(MenuActions.NEWBOOK_CHECK_ACCEPT);

		 
		JMenu baseMenu = new JMenu("������ͼ�����");// ��ʼ��������ͼ��˵�
		
		{
			JMenu readerManagerMItem = new JMenu("������Ϣ����");
			readerManagerMItem.add(MenuActions.READER_ADD);
			readerManagerMItem.add(MenuActions.READER_MODIFY);

			JMenu bookTypeManageMItem = new JMenu("ͼ��������");
			bookTypeManageMItem.add(MenuActions.BOOKTYPE_ADD);
			bookTypeManageMItem.add(MenuActions.BOOKTYPE_MODIFY);

			JMenu menu = new JMenu("ͼ����Ϣ����");
			menu.add(MenuActions.BOOK_ADD);
			menu.add(MenuActions.BOOK_MODIFY);

			baseMenu.add(readerManagerMItem);
			baseMenu.add(bookTypeManageMItem);
			baseMenu.add(menu);
			baseMenu.addSeparator();
			baseMenu.add(MenuActions.EXIT);
		}
		JMenu borrowManageMenu = new JMenu("ͼ����Ĺ���"); // ���Ĺ���
		
		borrowManageMenu.add(MenuActions.BORROW); // ����
		borrowManageMenu.add(MenuActions.GIVE_BACK); // �黹
		borrowManageMenu.add(MenuActions.BOOK_SEARCH); // ����

		JMenu sysManageMenu = new JMenu("ϵͳ����"); // ϵͳά��
		
		JMenu userManageMItem = new JMenu("�û�����"); // �û�����
		userManageMItem.add(MenuActions.USER_ADD);
		userManageMItem.add(MenuActions.USER_MODIFY);
		sysManageMenu.add(MenuActions.MODIFY_PASSWORD);
		sysManageMenu.add(userManageMItem);

		menuBar.add(baseMenu); // ���ͼ�����˵����˵���
		menuBar.add(bookOrderMenu); // ������鶩������˵����˵���
		menuBar.add(borrowManageMenu); // ��ӽ��Ĺ���˵����˵���
		menuBar.add(sysManageMenu); // ���ϵͳά���˵����˵���
		return menuBar;
	}
}
