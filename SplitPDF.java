import java.io.*;
import java.util.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
public class SplitPDF {
	
	public static void main(String args[]) throws IOException
	{
		String ipPath = "/Users/akshaywaghela/Desktop/SplitFiles/sussex_cd.pdf";
		File file=new File(ipPath);
		PDDocument document = PDDocument.load(file);
		
		int j=1;
		
		List<PDPage> test = new ArrayList<PDPage>();
		for(int k=0;k<document.getNumberOfPages();k++)
		{
			test.add(document.getPage(k));
		}
		int count=0;
		for(int a=0;a<test.size();a+=1)
		{
			PDDocument newDoc = new PDDocument();
			for(int b=a;b<a+1;b++)
			{
				PDPage p = test.get(b);
				newDoc.addPage(p);
			}
			newDoc.save("/Users/akshaywaghela/Desktop/SplitFiles/sussex_cd/"+ j++ +".pdf");
			newDoc.close();
			count+=1;
		}

		System.out.println(count);

		System.out.print("Document created");

	}
}
