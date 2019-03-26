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
		//实例化树的根节点
		root = makeSampleTree();
		//实例化的树模型
		treeModel = new DefaultTreeModel(root);
		//实例化一棵树
		tree = new JTree(treeModel);
		//设置树的选择模式是单一节点的选择模式（一次只能选中一个节点）
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		JFileChooser jfc=new JFileChooser();
		//注册树的监听对象，监听选择不同的树节点
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			//重写树的选择事件的处理方法
			@Override
			public void valueChanged(TreeSelectionEvent event) {
				// TODO Auto-generated method stub
				//获取选中节点的路径
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
						
							//取得新节点的父节点
						parentNode=(DefaultMutableTreeNode)(path.getLastPathComponent());
							//由DefaultTreeModel的insertNodeInto（）方法增加新节点
						treeModel.insertNodeInto(newNode,parentNode,parentNode.getChildCount());
				}
				
				 
				
				
				//获取选中的节点对象
				DefaultMutableTreeNode selectedNode =
						(DefaultMutableTreeNode) path.getLastPathComponent();
				String text="";
				
				//获取选中节点的内容，并显示到文本域中
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
		//实例化一个面板对象，布局是1行2列
		p = new JPanel(new GridLayout(1, 2));
		//在面板的左侧放置树
		p.add(new JScrollPane(tree));
		textArea = new JTextArea();
		//面板右侧放置文本域
		p.add(new JScrollPane(textArea));
		//将面板添加到窗体
		this.add(p);
		//设定窗口大小
		this.setSize(400,300);
		//设定窗口左上角坐标（X轴200像素，Y轴100像素）
		this.setLocation(200,100);
		//设定窗口默认关闭方式位退出应用程序
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置窗口可视（显示）
		this.setVisible(true);
		
	}

	//创建一棵树对象的方法
	public DefaultMutableTreeNode makeSampleTree(){
		root=new DefaultMutableTreeNode("我的电脑");
		//实例化树节点，并将节点添加到相应节点中
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
