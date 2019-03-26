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
	private static String inputpath="F:\\代码\\java\\chapter08";
	private static List<String[]> strarryList=new ArrayList<>();
	private static List<String> dirlist=new ArrayList<>();
	private static int deepth=0;
	/**
	 * <p>递归搜索指定路径及子路径下的所有特定名称的文件夹或文件,支持模糊匹配.</p>
	 * 
	 * @param path  要搜索的起始路径
	 * @param keyword	搜索的关键字
	 * @return	文件绝对路径集合
	 */
	public static List<String> searchByFileName(String path, String keyword,boolean isFindAll){
		
		File file = new File(path);	
		File[] files = file.listFiles();     //遍历该目录所有文件和文件夹对象	
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
				searchByFileName(files[i].toString(),keyword,isFindAll);       //递归操作，逐一遍历各文件夹内的文件
				
			}else{
				dir_count++;
				if(!files[i].isDirectory()&&isFindAll) {
					System.out.println(files[i].toString()+"depth:"+String.valueOf(dir_count));   //只打印文件，不打印文件夹
					
					strarry=files[i].toString().split(":");
					dirlist.add(strarry[1]);
					System.out.println(strarry[1]);

					strList.add(files[i].toString());
				}
				if(!files[i].isDirectory()&&files[i].toString().contains(keyword)&&!isFindAll) {
						System.out.println(files[i].toString()+"depth:"+String.valueOf(dir_count));   //只打印文件，不打印文件夹
						
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
			//用源地址长度 减去 末尾长度就可以得到需要的地址字符串
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
	 * <p>在指定目录及子目录下递归搜索所有特定后缀的文件.</p>
	 * 
	 * @param path 要搜索的起始路径
	 * @param suff 文件后缀名，例如 doc, rar
	 * @return 文件绝对路径集合
	 */
	public static List<String> searchBySuff(String path, String suff){
		
		

		return searchByFileName(path, suff,false);
}
	
	/**
	 * <p>以树形结构形式递归打印特定路径下的文件及子目录.</p>
	 * 
	 * @param path 起始路径
	 * @param depth 递归深度; 0表示不递归子目录，-1表示递归深度不限.
	 * @return 
	 */
	public static List<String> listDir(String path,int depth){
		
		deepth=depth;
		List<String> strlist=searchByFileName(path, "", true);
	
		
		
		return generatetree(dirlist, path);
		
}
	
	/**
	 * <p>以树形结构递归罗列指定目录中的文件及子目录，并将结果输出到文本文件中保存.</p>
	 * 
	 * @param path 起始路径
	 * @param depth 递归深度; 0表示不递归子目录，-1表示递归深度不限.
	 * @param txtFilePath 结果文件路径
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
