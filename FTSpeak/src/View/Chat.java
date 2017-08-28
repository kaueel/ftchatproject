package View;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsConfiguration;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Control.ComponentMover;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.AbstractListModel;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.JSeparator;


public class Chat {

	private JFrame frmFtchat;
	private JPanel panelMessagens;
	private JPanel panelContatos;
	private int width;
	private int height;
	private Point location;
	private MouseEvent pressed;
	private JPanel topPanelMessagens;
	private JLabel lblContatoNome;
	private JPanel panel;
	private JLabel label;
	private Panel abc;
	private Panel def;
	private boolean firstload = true;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chat window = new Chat();
					window.frmFtchat.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void Show() {
		try {
			Chat window = new Chat();
			window.frmFtchat.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Create the application.
	 */
	public Chat() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		frmFtchat = new JFrame();
		frmFtchat.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Vinicius\\Documents\\iconbar.png"));
		frmFtchat.setTitle("FTChat");
		frmFtchat.getContentPane().addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
				resizeWindows();
			}
		});
		
		
		frmFtchat.setExtendedState(frmFtchat.getState() | frmFtchat.MAXIMIZED_BOTH);
	
		
		
		
		
		frmFtchat.setBounds(100, 100, 800, 600);
		frmFtchat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFtchat.getContentPane().setLayout(null);
		Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
		
		panelMessagens = new JPanel();
		panelMessagens.setBounds(0, 0, 602, 600);
		frmFtchat.getContentPane().add(panelMessagens);
		panelMessagens.setLayout(null);
		
		topPanelMessagens = new JPanel();
		topPanelMessagens.setBackground(SystemColor.controlHighlight);
		topPanelMessagens.setBounds(0, 0, 602, 40);
		panelMessagens.add(topPanelMessagens);
		topPanelMessagens.setLayout(null);
		
		lblContatoNome = new JLabel("Contato Name");
		lblContatoNome.setForeground(SystemColor.textInactiveText);
		lblContatoNome.setFont(new Font("Arial", Font.PLAIN, 18));
		lblContatoNome.setBounds(10, 0, 582, 40);
		topPanelMessagens.add(lblContatoNome);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			Panel[] values = {abc, def};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(10, 51,592, 300);
		
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(-1);

		panelMessagens.add(list);
		
		abc = new Panel();
		abc.setBounds(20, 20, 300, 40);
		abc.setBackground(SystemColor.BLACK);
		
		def = new Panel();
		def.setBounds(20, 80, 300, 40);
		def.setBackground(SystemColor.BLACK);
		
		panelContatos = new JPanel();
		panelContatos.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
				
				if(frmFtchat.getWidth() > 1000) {
					if(firstload) {
						
						panelContatos.setBounds(frmFtchat.getWidth() - frmFtchat.getWidth()/100*30, 0, frmFtchat.getWidth()/100*25, 600);
						
						
						firstload = false;
						
					}
					
					panelMessagens.setBounds(0, 0, frmFtchat.getWidth()-panelContatos.getWidth(), frmFtchat.getHeight());
					panelContatos.setBounds(panelMessagens.getWidth(), 0, panelContatos.getWidth(), frmFtchat.getHeight());
					panel.setBounds(0, 0, panelContatos.getWidth(), panel.getHeight());
					panelContatos.setVisible(true);
					label.setBounds(-5, 0, panelContatos.getWidth(), panel.getHeight());
					topPanelMessagens.setBounds(0, 0, panelMessagens.getWidth(), topPanelMessagens.getHeight());
					lblContatoNome.setBounds(10, 0, panelMessagens.getWidth()-10, topPanelMessagens.getHeight());
					
				
				}
			}
		});
		panelContatos.setBackground(new java.awt.Color(43,50,53));
		panelContatos.setBounds(609, 0, 290, 600);
		frmFtchat.getContentPane().add(panelContatos);
		panelContatos.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new java.awt.Color(60,70,78));
		panel.setBounds(0, 0, 290, 40);
		panelContatos.add(panel);
		panel.setLayout(null);
		
		label = new JLabel("Contatos");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(SystemColor.menu);
		label.setFont(new Font("Arial", Font.PLAIN, 18));
		label.setBounds(0, 0, 290, 40);
		panel.add(label);
		
		Control.ComponentResizer cr = new Control.ComponentResizer();
		cr.setSnapSize(new Dimension(10, 10));
		cr.setDragInsets( new Insets(0,5, 0, 0) );

		cr.registerComponent(panelContatos);
		
	}
	
	
 
    
	
	
	private void resizeWindows() {
		
		if(frmFtchat.getWidth() > 1000) {
			panelMessagens.setBounds(0, 0, frmFtchat.getWidth()-panelContatos.getWidth(), frmFtchat.getHeight());
			panelContatos.setBounds(panelMessagens.getWidth(), 0, panelContatos.getWidth(), frmFtchat.getHeight());
			panelContatos.setVisible(true);
		}else {
			panelMessagens.setBounds(0, 0, frmFtchat.getWidth(), frmFtchat.getHeight()-34);
			panelContatos.setBounds(frmFtchat.getWidth()-panelContatos.getWidth(), 0, panelContatos.getWidth(), frmFtchat.getHeight());
			panelContatos.setVisible(false);
		}
		
		topPanelMessagens.setBounds(0, 0, panelMessagens.getWidth(), 40);
		
	}
}
