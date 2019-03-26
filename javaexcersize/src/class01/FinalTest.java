package class01;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class FinalTest {

	
	private static Course course;  		//课程
	private String txtDataFile;		//原始数据文件,txt格式
	private String reportFile;		//最终报告
	private static String charSet="GBK";		//文件采用的字符集，处理中文乱码问题
	
	char singlechar;
	/**
	 * 统计分析,生成报告文件 
	 * @throws IOException 
	 */
	public static void generateReport(String oldtext,String newtext) throws IOException{
		

		List<String> oldData=Files.readAllLines(Paths.get(oldtext),Charset.forName(charSet));
		List<Student> students=new ArrayList<Student>();
		Double sumCore=0.0;
		Student student;
		
		int counter=0;
		for(String s:oldData) {
			
			if(counter==0) {
				counter++;
				continue;
				}
			if(counter==3) {
				counter++;
				continue;
				};

			String[] strs=s.split("\\s");
			if(counter==1) {
				course=new Course(strs[0],strs[1], strs[2]);

				};
			if(counter>=4) {
				sumCore= Integer.valueOf(strs[2])*0.1+ Integer.valueOf(strs[3])*0.1+ Integer.valueOf(strs[4])*0.1+ Integer.valueOf(strs[5])*0.1+Integer.valueOf(strs[6])*0.6;
				student=new Student(Integer.valueOf(strs[0]), strs[1], Integer.valueOf(strs[2]), Integer.valueOf(strs[3]), Integer.valueOf(strs[4]), Integer.valueOf(strs[5]), Integer.valueOf(strs[6]), sumCore);
				
				students.add(student);
			}
			
			counter++;
		}
		Double max=students.get(0).getSumScore();
		Double min=students.get(0).getSumScore();
		Double ave=0.0;
		Double sum=0.0;
		Integer s0_29=0;
		Integer s30_59=0;
		Integer s60_69=0;
		Integer s70_79=0;
		Integer s80_89=0;
		Integer s90_100=0;
		Integer countStudent=students.size();
		for(Student s:students) {
			
			if (s.getSumScore()>max) {
				max=s.getSumScore();
			} else if(s.getSumScore()<min) {
				min=s.getSumScore();
			}
			
			if(s.getSumScore()>=0&&s.getSumScore()<=29) {
				
				s0_29++;
			}else if(s.getSumScore()>=30&&s.getSumScore()<=59) {
				
				s30_59++;
			}else if(s.getSumScore()>=60&&s.getSumScore()<=69) {
				s60_69++;
				
			}else if(s.getSumScore()>=70&&s.getSumScore()<=79) {
				
				s70_79++;
			}else if(s.getSumScore()>=80&&s.getSumScore()<=89) {
				s80_89++;
				
			}else if(s.getSumScore()>=90&&s.getSumScore()<=100) {
				
				s90_100++;
			}
			
			sum=sum+s.getSumScore();
		}
		ave=sum/students.size();
		
	
		//处理数据结束开始写数据
		
		for(int i=0,j=0;i<oldData.size();i++) {
			
			if(i==3) {
				String newline=oldData.get(i)+"	"+"课程成绩";
				oldData.set(i, newline);
				
				
				continue;
			}
			if(i>=4) {
				
				String newline=students.get(j).getStuNum()+"	"+students.get(j).getStuName()+"	"+students.get(j).getCheckAttmpet()+"	"+students.get(j).getHomworkScore()+"	"+students.get(j).getExperimentsScore()+"	"+students.get(j).getMidTermScore()+"	"+students.get(j).getEndTermScore()+"	"+students.get(j).getSumScore();
				oldData.set(i, newline);
				j++;
				
			}
			
			
			
			
		}
		
		String newlineMaxScore="最高分"+"			"+String.valueOf(max);
		String newlineMinScore="最低分"+"			"+String.valueOf(min);
		String newlineAveScore="平均分"+"			"+String.valueOf(ave);
		String newline0_29="0~29"+"			"+String.valueOf(s0_29)+"人";
		String newline30_59="30~59"+"			"+String.valueOf(s30_59)+"人";
		String newline60_69="60~69"+"			"+String.valueOf(s60_69)+"人";
		String newline70_79="70~79"+"			"+String.valueOf(s70_79)+"人";
		String newline80_89="80~89"+"			"+String.valueOf(s80_89)+"人";
		String newline90_100="90~100"+"			"+String.valueOf(s90_100)+"人";
		oldData.add(newlineMaxScore);
		oldData.add(newlineMinScore);
		oldData.add(newlineAveScore);
		oldData.add(newline0_29);
		oldData.add(newline30_59);
		oldData.add(newline60_69);
		oldData.add(newline70_79);
		oldData.add(newline80_89);
		oldData.add(newline90_100);
		
		printReport(oldData,newtext);
		System.out.println("success");
		
		
	}
/**
	 * 屏幕上打印报告 
 * @throws IOException 
	 */

	public static void printReport(List<String> datas,String filePath) throws IOException{
		
		for(String line:datas) {
			
			System.out.println(line);
		}
		Files.write(Paths.get(filePath), datas, Charset.forName(charSet));
	}
	
	public static void main(String[] args) throws IOException {
		
		generateReport("student.txt","result.txt");
		
	}

}
