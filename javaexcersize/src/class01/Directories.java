package class01;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Directories {

	
	private static int dir_count=0;
	private static String inputpath="F:\\����\\java\\chapter08";
	private static List<String[]> strarryList=new ArrayList<>();
	private static List<String> dirlist=new ArrayList<>();
	private static int deepth=0;
	/**
	 * <p>�ݹ�����ָ��·������·���µ������ض����Ƶ��ļ��л��ļ�,֧��ģ��ƥ��.</p>
	 * 
	 * @param path  Ҫ��������ʼ·��
	 * @param keyword	�����Ĺؼ���
	 * @return	�ļ�����·������
	 */
	public static List<String> searchByFileName(String path, String keyword,boolean isFindAll){
		
		File file = new File(path);	
		File[] files = file.listFiles();     //������Ŀ¼�����ļ����ļ��ж���	
		System.out.println(path);
		String[] strarry=path.split(":");
		String[] oldpath=strarry[1].split("\\\\");
	
		String temppathstr=strarry[1].substring(strarry[1].length()-oldpath.length-2, strarry[1].length());
		String[] nowpath=temppathstr.split("\\\\");
		
		
		dirlist.add(strarry[1]);
		
		System.out.println("dirlist:"+strarry[1]);
		
		List<String> strList=new ArrayList<>();
		
		if(nowpath.length>deepth) return strList;
		
		for(int i = 0; i<files.length;i++){
			
			if(files[i].isDirectory()){
				
				strList.add(files[i].toString());
				searchByFileName(files[i].toString(),keyword,isFindAll);       //�ݹ��������һ�������ļ����ڵ��ļ�
				
			}else{
				dir_count++;
				if(!files[i].isDirectory()&&isFindAll) {
					System.out.println(files[i].toString()+"depth:"+String.valueOf(dir_count));   //ֻ��ӡ�ļ�������ӡ�ļ���
					
					strarry=files[i].toString().split(":");
					dirlist.add(strarry[1]);
					System.out.println(strarry[1]);

					strList.add(files[i].toString());
				}
				if(!files[i].isDirectory()&&files[i].toString().contains(keyword)&&!isFindAll) {
						System.out.println(files[i].toString()+"depth:"+String.valueOf(dir_count));   //ֻ��ӡ�ļ�������ӡ�ļ���
						
						strarry=files[i].toString().split(":");
						dirlist.add(strarry[1]);
						System.out.println(strarry[1]);
						
						strList.add(files[i].toString());
						}
					
					
					
					
					}
			
			}
		dir_count++;

		return strList;
}

	
	
	
	
	public static List<String> generatetree(List<String> stringList,String pathStr) {
		
		String[] oldpath=pathStr.split(":");
		oldpath=oldpath[1].split("\\\\");
		String[] newPath= {};
		List<String[]> newPathList=new ArrayList<>();
		String temppathstr="";
		for (String strings : stringList) {
			//��Դ��ַ���� ��ȥ ĩβ���ȾͿ��Եõ���Ҫ�ĵ�ַ�ַ���
			temppathstr=strings.substring(pathStr.length()-oldpath[oldpath.length-1].length()-2, strings.length());
			newPath=temppathstr.split("\\\\");
			

			if(newPath.length==2) {
				int pathStrLen=newPath[0].length();
				newPath[0]="|";
				while((pathStrLen--)>0) {
					newPath[0]=newPath[0]+"_";
				}
				
				
			}
			
			if(newPath.length>2) {
				
				int pathcount=newPath.length;
				
				int pathStrLen=newPath[pathcount-2].length();
				newPath[pathcount-2]="|_";
				while((pathStrLen--)>0) {
					newPath[0]=newPath[0]+"_";
				}
				pathcount=pathcount-2;
				
				while((--pathcount)>=0) {
					
					int sLen=newPath[pathcount].length();
					newPath[pathcount]="";
					while((sLen--)>0) {
						newPath[pathcount]=" "+newPath[pathcount];
					}
					
				}
				
				
			}
			
			newPathList.add(newPath);
		}
		
		
		for (String[] strings : newPathList) {
			temppathstr="";
		for (String string : strings) {
			temppathstr=temppathstr+string;
			
		}
		
		
		stringList.add(temppathstr);
	
		}
		
		
		

		return stringList;
	}
	
	
	
	
	
	
	
	
	/**
	 * <p>��ָ��Ŀ¼����Ŀ¼�µݹ����������ض���׺���ļ�.</p>
	 * 
	 * @param path Ҫ��������ʼ·��
	 * @param suff �ļ���׺�������� doc, rar
	 * @return �ļ�����·������
	 */
	public static List<String> searchBySuff(String path, String suff){
		
		

		return searchByFileName(path, suff,false);
}
	
	/**
	 * <p>�����νṹ��ʽ�ݹ��ӡ�ض�·���µ��ļ�����Ŀ¼.</p>
	 * 
	 * @param path ��ʼ·��
	 * @param depth �ݹ����; 0��ʾ���ݹ���Ŀ¼��-1��ʾ�ݹ���Ȳ���.
	 * @return 
	 */
	public static List<String> listDir(String path,int depth){
		
		deepth=depth;
		List<String> strlist=searchByFileName(path, "", true);
	
		
		
		return generatetree(dirlist, path);
		
}
	
	/**
	 * <p>�����νṹ�ݹ�����ָ��Ŀ¼�е��ļ�����Ŀ¼���������������ı��ļ��б���.</p>
	 * 
	 * @param path ��ʼ·��
	 * @param depth �ݹ����; 0��ʾ���ݹ���Ŀ¼��-1��ʾ�ݹ���Ȳ���.
	 * @param txtFilePath ����ļ�·��
	 */
	public static List<String> listDir (String path, int depth, String txtFilePath){

		List<String> strlist=listDir(path,depth);
		try {
			Files.write(Paths.get(txtFilePath), strlist);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return strlist;
	}
	

	
	public static void main(String[] args) {
		
//		List<String> pathList=listDir(inputpath,5);
		List<String> pathList=listDir(inputpath,5,"out.txt");
		for (String string : pathList) {
			System.out.println(string);
		}
	}
	
	
}
