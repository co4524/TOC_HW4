/******************************************************
	學號:F74006226
	姓名:蔡徳倚
	Toc_HW4
*******************************************************/
import java.io.*;
import java.net.URL;

import org.json.*;

public class TocHw4 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		try {	
			int a,count=0,count2=0,k,maxprice=0,minprice=0,maxmatch=0,kk=0,PrintTime=0;
			int[] dirty = new int[2000];
			int[] Countmatch = new int[2000];
			int[] Finalmatch = new int[2000];			
			String[] addr = new String[2000];
			int[][] year = new int[2000][2000];
			int[][] price = new int[2000][2000];
			String AfterSplit;
			URL url=new URL(args[0]);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			JSONArray array=new JSONArray(new JSONTokener(br));       
			for(int i=0;i<array.length();++i)
			{
				JSONObject item=array.getJSONObject(i);
				if(item.get("土地區段位置或建物區門牌").toString().contains("路")==true && dirty[i]!=1)
				{
					count=0;
					dirty[i]=1;
					a=item.get("土地區段位置或建物區門牌").toString().indexOf('路');
					AfterSplit = item.get("土地區段位置或建物區門牌").toString().substring(0,a+1);
					//System.out.println(AfterSplit);
					for(int b=0;b<addr.length;b++)
					{
						if(addr[b]!=null)
						{
							if(addr[b].equals(AfterSplit)==true)
							{
							count++;
							k=Countmatch[b];
							year[b][k]=item.getInt("交易年月");
							price[b][k]=item.getInt("總價元");
							Countmatch[b]++;
							}
						}
					}
					if(count==0)
					{
						addr[count2]=AfterSplit;
						//System.out.println(addr[count2]);
						year[count2][0]=item.getInt("交易年月");
						price[count2][0]=item.getInt("總價元");
						Countmatch[count2]++;
						count2++;	
					}
				}
				else if(item.get("土地區段位置或建物區門牌").toString().contains("街")==true && dirty[i]!=1)
				{
					count=0;
					dirty[i]=1;
					a=item.get("土地區段位置或建物區門牌").toString().indexOf('街');
					AfterSplit = item.get("土地區段位置或建物區門牌").toString().substring(0,a+1);
					for(int b=0;b<addr.length;b++)
					{
						if(addr[b]!=null)
						{
							if(addr[b].equals(AfterSplit)==true)
							{
							count++;
							k=Countmatch[b];
							year[b][k]=item.getInt("交易年月");
							price[b][k]=item.getInt("總價元");
							Countmatch[b]++;
							}
						}
					}
					if(count==0)
					{
						addr[count2]=AfterSplit;
						//System.out.println(addr[count2]);
						year[count2][0]=item.getInt("交易年月");
						price[count2][0]=item.getInt("總價元");
						Countmatch[count2]++;						
						count2++;
					}

					//System.out.println(AfterSplit);
				}
				else if(item.get("土地區段位置或建物區門牌").toString().contains("大道")==true && dirty[i]!=1)
				{
					count=0;
					dirty[i]=1;
					a=item.get("土地區段位置或建物區門牌").toString().indexOf("大道");
					AfterSplit = item.get("土地區段位置或建物區門牌").toString().substring(0,a+2);
					for(int b=0;b<addr.length;b++)
					{
						if(addr[b]!=null)
						{
							if(addr[b].equals(AfterSplit)==true)
							{
							count++;
							k=Countmatch[b];
							year[b][k]=item.getInt("交易年月");
							price[b][k]=item.getInt("總價元");
							Countmatch[b]++;
							}
						}
					}
					if(count==0)
					{
						addr[count2]=AfterSplit;
						//System.out.println(addr[count2]);
						year[count2][0]=item.getInt("交易年月");
						price[count2][0]=item.getInt("總價元");
						Countmatch[count2]++;						
						count2++;
					}
					//System.out.println(AfterSplit);
				}	
				else if(item.get("土地區段位置或建物區門牌").toString().contains("巷")==true && dirty[i]!=1)
				{
					count=0;
					dirty[i]=1;
					a=item.get("土地區段位置或建物區門牌").toString().indexOf('巷');
					AfterSplit = item.get("土地區段位置或建物區門牌").toString().substring(0,a+1);
					for(int b=0;b<addr.length;b++)
					{
						if(addr[b]!=null)
						{
							if(addr[b].equals(AfterSplit)==true)
							{
							count++;
							k=Countmatch[b];
							year[b][k]=item.getInt("交易年月");
							price[b][k]=item.getInt("總價元");
							Countmatch[b]++;
							}
						}
					}
					if(count==0)
					{
						addr[count2]=AfterSplit;
						//System.out.println(addr[count2]);
						year[count2][0]=item.getInt("交易年月");
						price[count2][0]=item.getInt("總價元");
						Countmatch[count2]++;						
						count2++;
					}
					//System.out.println(AfterSplit);

				}

			}
			//System.out.println(count2);
			/*for(int b=0;b<2000;b++)
			{
				System.out.println(Countmatch[b]);
			}*/



			for(int i=0;i<2000;i++)
			{
				//System.out.print('\n');
				for(int j=0;j<1000;j++)
				{
					for(int m=1;m<1000;m++)
					{
					if(year[i][j]==year[i][j+m] && year[i][j]!=0)
						{
						year[i][j+m]=0;
						}
					}
					if(year[i][j]!=0)
					{
					Finalmatch[i]++;
					}
					//System.out.print("	"+year[i][j]);				
				}
			}


			while(PrintTime==0){

				maxmatch=Finalmatch[0];
				for(int i=0;i<2000;i++)
				{
					if(maxmatch<Finalmatch[i])
					{
						maxmatch=Finalmatch[i];
						kk=i;
					}
				}




				maxprice=price[kk][0];
				minprice=price[kk][0];
				for(int i=0;i<2000;i++)
				{
					if(maxprice<price[kk][i])
					{
						maxprice=price[kk][i];
					}
					if(minprice>price[kk][i] && price[kk][i]!=0)
					{
						minprice=price[kk][i];
					}
				}
				System.out.println(addr[kk]+",最高成交價: "+maxprice+",最低成交價: "+minprice);	
				Finalmatch[kk]=0;
				PrintTime=1;
				for(int i=0;i<2000;i++)
				{
					if(maxmatch==Finalmatch[i])
					{
						PrintTime=0;
					}
				}


			}//while


		}//try



		catch(Exception e) {
            System.out.println("發生了" + e + "例外");
        }




	}

}