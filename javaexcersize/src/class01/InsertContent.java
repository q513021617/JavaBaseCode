package class01;

import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

//import sun.security.util.Length;


public class InsertContent {

	public static String charset="GBK";
	/**
	 * 
	 * @param destFile 目标文件
	 * @param position 插入起始行
	 * @param sourceFile 待插入数据源文件
	 * @param offset 待插入数据起始行
	 * @param length 待插入数据行数
	 * @throws IOException
	 */
	public static void txtInsert(String destFile, int position, String sourceFile, int offset, int length) throws IOException{
		
//		打开文件
		List<String> oldData=Files.readAllLines(Paths.get(destFile),Charset.forName(charset));
		
		List<String> tempstrlist=new ArrayList<>();
		
//		将position位置后面的数据先存入临时变量
		for (int i = 0; i < position; i++) {
			
			tempstrlist.add(oldData.get(i));
		}
		
		
//		想要写入的内容
		List<String> newData=Files.readAllLines(Paths.get(sourceFile),Charset.forName(charset));
//		
		
		for (int i = offset-1; i <= length; i++) {
			tempstrlist.add(newData.get(i));
		}
		
		for (int i = position; i < oldData.size(); i++) {
			
			tempstrlist.add(oldData.get(i));
		}
		
		Files.write(Paths.get(destFile), tempstrlist, Charset.forName(charset));
		
		
	}
	
	
	public static void main(String[] args) throws IOException {
		txtInsert("result3.txt", 2, "result2.txt", 3, 4);
	}
	
	
}
