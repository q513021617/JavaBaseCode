package javaTree;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

public class JTreeDemo extends JFrame{
	private DefaultMutableTreeNode root;
	private DefaultTreeModel treeModel;
	private JTree tree;
	private JTextArea textArea;
	private JPanel p;
	public JTreeDemo(){
		super();
		//ʵ�������ĸ��ڵ�
		root = makeSampleTree();
		//ʵ��������ģ��
		treeModel = new DefaultTreeModel(root);
		//ʵ����һ����
		tree = new JTree(treeModel);
		//��������ѡ��ģʽ�ǵ�һ�ڵ��ѡ��ģʽ��һ��ֻ��ѡ��һ���ڵ㣩
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		JFileChooser jfc=new JFileChooser();
		//ע�����ļ������󣬼���ѡ��ͬ�����ڵ�
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			//��д����ѡ���¼��Ĵ�����
			@Override
			public void valueChanged(TreeSelectionEvent event) {
				// TODO Auto-generated method stub
				//��ȡѡ�нڵ��·��
				TreePath path = tree.getSelectionPath();
				DefaultMutableTreeNode nowNode=new DefaultMutableTreeNode(path);
				File file =new File("");
				if(path!=null)
				   file = new File(path.getLastPathComponent().toString());
				 File[] files=null;
				 System.out.println(path.getLastPathComponent().toString());
				 
				 if(path == null ||!file.exists())
						return;
				 if(file.isDirectory()) {
					 
					 files=file.listFiles();
					 }else return;
				 
				 
				 for (File f : files) {
						DefaultMutableTreeNode rootfiles=new DefaultMutableTreeNode(f.toString());
						root.add(rootfiles);
					}
				
				 for (File file2 : files) {
					 if(!file2.isDirectory()) continue;
					 	DefaultMutableTreeNode parentNode=null;
						
						DefaultMutableTreeNode newNode=new DefaultMutableTreeNode(file2.getPath());
						
						newNode.setAllowsChildren(true);
						
							//ȡ���½ڵ�ĸ��ڵ�
						parentNode=(DefaultMutableTreeNode)(path.getLastPathComponent());
							//��DefaultTreeModel��insertNodeInto�������������½ڵ�
						treeModel.insertNodeInto(newNode,parentNode,parentNode.getChildCount());
				}
				
				 
				
				
				//��ȡѡ�еĽڵ����
				DefaultMutableTreeNode selectedNode =
						(DefaultMutableTreeNode) path.getLastPathComponent();
				String text="";
				
				//��ȡѡ�нڵ�����ݣ�����ʾ���ı�����
				for (File file2 : files) {
					text+=file2.getPath()+"\n";
				}
				
				
				try {
					java.awt.Desktop.getDesktop().open(file);
				} catch (IOException e) {
					e.printStackTrace();
				}
				textArea.setText(text.toString());
				
			}
		});
		//ʵ����һ�������󣬲�����1��2��
		p = new JPanel(new GridLayout(1, 2));
		//��������������
		p.add(new JScrollPane(tree));
		textArea = new JTextArea();
		//����Ҳ�����ı���
		p.add(new JScrollPane(textArea));
		//�������ӵ�����
		this.add(p);
		//�趨���ڴ�С
		this.setSize(400,300);
		//�趨�������Ͻ����꣨X��200���أ�Y��100���أ�
		this.setLocation(200,100);
		//�趨����Ĭ�Ϲرշ�ʽλ�˳�Ӧ�ó���
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���ô��ڿ��ӣ���ʾ��
		this.setVisible(true);
		
	}

	//����һ��������ķ���
	public DefaultMutableTreeNode makeSampleTree(){
		root=new DefaultMutableTreeNode("�ҵĵ���");
		//ʵ�������ڵ㣬�����ڵ���ӵ���Ӧ�ڵ���
		File[] files=File.listRoots();
		int i=0;
		
		
		for (File f : files) {
			DefaultMutableTreeNode rootfiles=new DefaultMutableTreeNode(f.toString());
			root.add(rootfiles);
		}
		
		
		
		return root;
		
	}
	public static void main(String[] args){
		new JTreeDemo();
	}

}
