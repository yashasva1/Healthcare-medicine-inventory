import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
class Medicine
{
   public static void Clear()
   {
      for (int i=1;i<=50;i++)
         System.out.println();
   }
   public static void Show() 
   {
      Clear();
      System.out.println("\n\t\t\t");
      System.out.println("\t\t\t         W E L C O M E        ");               
      System.out.println("\t\t\t **************************** "); 
      System.out.println("\t\t\t             T O              ");
      System.out.println("\t\t\t **************************** "); 
      System.out.println("\t\t\t****   M E D I C I N E   **** ");
      System.out.println("\t\t\t **************************** ");             
      System.out.println("\t\t\t ****  I N V E N T O R Y **** ");
      System.out.println("\t\t\t***************************** ");
      System.out.println("\t\t\t *****  C O N T R O L    **** ");
      System.out.println("\t\t\t ***************************  ");
      System.out.println("\t\t\t");
      for (int i=1;i<=9;i++)
         System.out.println();
      System.out.println("\t\t\t Please Sit Back !!!");
      System.out.println("\t\t\t  Initializing");
      for (long i=1;i<=80000000;i++)
         if(i%1000000==0)
            System.out.print("");
   }
   public static void NewEntry() throws IOException
   {
       Clear();
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       File fil=new File("Medicine.dat");
       DataOutputStream dos=new DataOutputStream(new FileOutputStream(fil,true));
       Clear();
       System.out.println("          Please Medicine Details as  Below");
       System.out.println("\n\n**");
       System.out.print("Enter THE NAME OF THE MEDICINE : ");
       String mname=br.readLine( );
       System.out.print("Enter THE NAME OF THE COMPANY : ");
       String company=br.readLine();
       System.out.print("Enter THE COST OF THE MEDICINE : ");
       double cost=Double.parseDouble(br.readLine( ));
       System.out.print("Enter THE QUANTITY RECEIVED : ");
       int quantity=Integer.parseInt(br.readLine( ));
       System.out.println();
       dos.writeUTF(mname);
       dos.writeUTF(company);
       dos.writeDouble(cost);
       dos.writeInt(quantity);
       System.out.println("\n\n**");
       System.out.println("\n....");
       System.out.print("Press ENTER to Back to MAIN MENU....");
       br.read();
       dos.close();
   }
   public static void Change( )throws IOException
   {
       Clear();
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       DataOutputStream dos= new DataOutputStream(new FileOutputStream

("temp.dat"));
       DataInputStream dis= new DataInputStream(new FileInputStream

("Medicine.dat"));
       String mname,company,name;
       int quantity,found=0;
       double cost;
       System.out.print("\n\nEnter the MEDICINE NAME :->> ");
       name=br.readLine();
       try
       {
          while(true)
          {
             mname=dis.readUTF();
             company=dis.readUTF();
             cost=dis.readDouble();
             quantity=dis.readInt();
             if(name.equalsIgnoreCase(mname))
             {
                System.out.println("Medicine Name : "+mname);
                System.out.println("Company Name  : "+company);
                System.out.println("Medicine Cost : "+cost);
                System.out.println("Quantity      : "+quantity);
                System.out.print("\n\nInformation CORRECT ? [y/n] :->> ");
                char ans=br.readLine().charAt(0);
                if(ans=='y' || ans=='Y')
                {
                  found=1;
                  System.out.println("Enter the Correct Details...");
                  System.out.println("");
                  System.out.print("Enter THE NAME OF THE MEDICINE : ");
                  mname=br.readLine( );
                  System.out.print("Enter THE NAME OF THE COMPANY : ");
                  company=br.readLine();
                  System.out.print("Enter THE COST OF THE MEDICINE : ");
                  cost=Double.parseDouble(br.readLine( ));
                  System.out.print("Enter THE QUANTITY RECEIVED : ");
                  quantity=Integer.parseInt(br.readLine( ));
                  System.out.println("");
                }
             }
             dos.writeUTF(mname);
             dos.writeUTF(company);
             dos.writeDouble(cost);
             dos.writeInt(quantity);
          }
       }
       catch(EOFException e1){}
       if (found==0)
          System.out.println("\n\nSorry.....NOT FOUND.....");
       else
          System.out.println("\n\nData Updated............");
       dos.close();
       dis.close();
       File ff1=new File("Medicine.dat");
       ff1.delete();
       File ff2 = new File("temp.dat");
       File ff3 = new File("Medicine.dat");
       ff2.renameTo(ff3);
       System.out.print("Press ENTER to go to main MENU....");
       br.readLine();
   }
   public static void Delete( )throws IOException
   {
       Clear();
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       DataOutputStream dos= new DataOutputStream(new FileOutputStream

("temp.dat"));
       DataInputStream dis= new DataInputStream(new FileInputStream

("Medicine.dat"));
       String mname,company,name;
       int quantity,found=0;
       double cost;
       System.out.print("\n\nEnter the MEDICINE NAME :->> ");
       name=br.readLine();
       boolean flag=true;
       try
       {
          while(true)
          {
             mname=dis.readUTF();
             company=dis.readUTF();
             cost=dis.readDouble();
             quantity=dis.readInt();
             if(name.equalsIgnoreCase(mname))
             {
                System.out.println("Medicine Name : "+mname);
                System.out.println("Company Name  : "+company);
                System.out.println("Medicine Cost : "+cost);
                System.out.println("Quantity      : "+quantity);
                System.out.print("\n\nInformation CORRECT to DELETE ? [y/n] :->> ");
                char ans=br.readLine().charAt(0);
                if(ans=='y' || ans=='Y')
                {
                  found=1; flag=false;
                }
             }
             if (flag==true)
             {
                dos.writeUTF(mname);
                dos.writeUTF(company);
                dos.writeDouble(cost);
                dos.writeInt(quantity);
             }
             flag=true;
          }
       }
       catch(EOFException e1){}
       if (found==0)
          System.out.println("\n\nSorry.....NOT FOUND.....");
       else
          System.out.println("\n\nData Updated............");
       dos.close();
       dis.close();
       File ff1=new File("Medicine.dat");
       ff1.delete();
       File ff2 = new File("temp.dat");
       File ff3 = new File("Medicine.dat");
       ff2.renameTo(ff3);
       System.out.print("Press ENTER to go to main MENU....");
       br.readLine();
   }
   public static void Return( )throws IOException
   {
       Clear();
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       DataOutputStream dos= new DataOutputStream(new FileOutputStream

("temp.dat"));
       DataInputStream dis= new DataInputStream(new FileInputStream

("Medicine.dat"));
       String mname,company,name;
       int quantity,found=0,rtn;
       double cost;
       System.out.print("\n\nEnter the MEDICINE NAME :->> ");
       name=br.readLine();
       try
       {
          while(true)
          {
             mname=dis.readUTF();
             company=dis.readUTF();
             cost=dis.readDouble();
             quantity=dis.readInt();
             if(name.equalsIgnoreCase(mname))
             {
                System.out.println("Medicine Name : "+mname);
                System.out.println("Company Name  : "+company);
                System.out.println("Medicine Cost : "+cost);
                System.out.println("Quantity      : "+quantity);
                System.out.print("\n\nInformation CORRECT ? [y/n] :->> ");
                char ans=br.readLine().charAt(0);
                if(ans=='y' || ans=='Y')
                {
                  System.out.println("\nEnter the Quantity of EXPIRED for RETURN :->> ");
                  rtn=Integer.parseInt(br.readLine());
                  found=1;
                  if(quantity>=rtn)
                    quantity=quantity-rtn;
                  else
                  {
                    System.out.println("\nThe ENTERED Quantity is invalid..");
                    br.readLine();
                  }
                }
             }
             dos.writeUTF(mname);
             dos.writeUTF(company);
             dos.writeDouble(cost);
             dos.writeInt(quantity);
          }
       }
       catch(EOFException e1){}
       if (found==0)
          System.out.println("\n\nSorry.....NOT FOUND.....");
       else
          System.out.println("\n\nData Updated............");
       dos.close();
       dis.close();
       File ff1=new File("Medicine.dat");
       ff1.delete();
       File ff2 = new File("temp.dat");
       File ff3 = new File("Medicine.dat");
       ff2.renameTo(ff3);
       System.out.print("Press ENTER to go to main MENU....");
       br.readLine();
   }
   public static void Issue( )throws IOException
   {
       Clear();
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       DataOutputStream dosc= new DataOutputStream(new FileOutputStream("selling.dat",true));
       String date,cname,cname1,address1,date1,address,mname,company,name;
       int quantity,found=0,rtn;
       double cost;
       System.out.print("Enter today's DATE [dd/mm/yyyy]:->> ");
       date=br.readLine();
       System.out.print("Enter Customer's Name :->> ");
       cname=br.readLine();
       System.out.print("Enter Customer's Address :->> ");
       address=br.readLine();
       char opt='y';
       while(opt=='y' || opt=='Y')
       {
          DataOutputStream dos= new DataOutputStream(new FileOutputStream("temp.dat"));
          DataInputStream dis= new DataInputStream(new FileInputStream("Medicine.dat"));
          System.out.print("\n\nEnter the MEDICINE NAME :->> ");
          name=br.readLine();
          try
          {
             while(true)
             {
                mname=dis.readUTF();
                company=dis.readUTF();
                cost=dis.readDouble();
                quantity=dis.readInt();
                if(name.equalsIgnoreCase(mname) && found ==0)
                {
                   System.out.println("");
                   System.out.println("Medicine Name : "+mname);
                   System.out.println("Company Name  : "+company);
                   System.out.println("Medicine Cost : "+cost);
                   System.out.println("Quantity Avail: "+quantity);
                   System.out.println("");
                   System.out.print("\n\nInformation CORRECT ? [y/n] :->> ");
                   char ans=br.readLine().charAt(0);
                   if(ans=='y' || ans=='Y')
                   {
                     System.out.print("\nEnter the Quantity the USER NEED out of above displayed quantity :->> ");
                     rtn=Integer.parseInt(br.readLine());
                     found=1;
                     if(quantity>=rtn)
                     {
                       quantity=quantity-rtn;
                       dosc.writeUTF(cname);
                       dosc.writeUTF(address);
                       dosc.writeUTF(date);
                       dosc.writeUTF(mname);
                       dosc.writeUTF(company);
                       dosc.writeDouble(cost);
                       dosc.writeInt(rtn);
                     }
                     else
                     {
                       System.out.println("\nThe ENTERED Quantity is invalid..");
                       br.readLine();
                     }
                   }
                }
                dos.writeUTF(mname);
                dos.writeUTF(company);
                dos.writeDouble(cost);
                dos.writeInt(quantity);
             }
          }
          catch(EOFException e1){}
          if (found==0)
             System.out.println("\n\nSorry.....MEDICINE NOT FOUND.....");
          else
             System.out.println("\n\nData Updated............");
          dos.close();
          dis.close();
          found=0;
          File ff1=new File("Medicine.dat");
          ff1.delete();
          File ff2 = new File("temp.dat");
          File ff3 = new File("Medicine.dat");
          ff2.renameTo(ff3);
          System.out.print("Any more to Purchase [y/n] :->> ");
          opt=br.readLine().charAt(0);
       }
       dosc.close();
       double amt,total=0.0;
       Clear();
       DataInputStream disc= new DataInputStream(new FileInputStream("selling.dat"));
       System.out.println("NITU's MEDICAL STORE");
       System.out.println("\n\n");
       System.out.println("Customer's Name : "+cname+"\nAddress : "+address);
       System.out.println("*");
       System.out.println(" Medicine Name        Cost         Quantity        Amount");
       System.out.println("*");
       try
       {
          while(true)
          {
             cname1=disc.readUTF();
             address1=disc.readUTF();
             date1=disc.readUTF();
             mname=disc.readUTF();
             company=disc.readUTF();
             cost=disc.readDouble();
             rtn=disc.readInt();
             if(cname1.equalsIgnoreCase(cname) && address1.equalsIgnoreCase(address) && date.equalsIgnoreCase(date1))
             {
                amt=cost*rtn; total=total+amt;
                System.out.print(mname+"\t"+cost+"\t"+rtn+"\t"+amt+"\n");
             }
          }
       }
       catch(EOFException e1){}
       System.out.println("*");
       System.out.println("Total Amount : "+total);
       System.out.println("*");
       disc.close();
       System.out.print("Press ENTER to go to main MENU....");
       br.readLine();
   }      
   public static void Stock()throws IOException
   {
       Clear();
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       DataInputStream dis= new DataInputStream(new FileInputStream("Medicine.dat"));
       String mname,company,name;
       int quantity,found=0,rtn;
       double cost;
       try
       {
          while(true)
          {
             mname=dis.readUTF();
             company=dis.readUTF();
             cost=dis.readDouble();
             quantity=dis.readInt();
          }
       }
       catch(EOFException e1){}
       dis.close();
       System.out.print("Press ENTER to go to main MENU....");
       br.readLine();
   }
}
class MediMain
{    
   public static void main(String arg[ ])throws IOException
   {
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      Medicine a=new Medicine();
      int  chc=1;
      while (chc != 4)
      {
        a.Clear();
        System.out.println();
        System.out.println("||");
        System.out.println("|                  MAIN MENU                   |");
        System.out.println("||");
        System.out.println("|   1. For MASTER HANDLING                     |");
        System.out.println("|                                              |");
        System.out.println("|   2. For TRANSACTION HANDLING                |");
        System.out.println("|                                              |");
        System.out.println("|   3. For STOCK REPORT                        |");
        System.out.println("|                                              |");
        System.out.println("|   4. For EXIT                                |");
        System.out.println("||");
        System.out.print("        Enter your Choice Please: ");
        chc=Integer.parseInt(br.readLine( ));
        switch(chc)
        {
           case 1:
              int ch1=0;
              while (ch1 != 5)
              {
                 a.Clear();
                 System.out.println();
                 System.out.println("------------------------------------------------");
                 System.out.println("|                  MASTER MENU                 |");
                 System.out.println("|----------------------------------------------|");
                 System.out.println("|   1. NEW ENTRY                               |");
                 System.out.println("|                                              |");
                 System.out.println("|   2. RESTORE DAMAGE                          |");
                 System.out.println("|                                              |");
                 System.out.println("|   3. RETURN EXPRIED                          |");               
                 System.out.println("|                                              |");
                 System.out.println("|   4. CHANGE ENTRY                            |");
                 System.out.println("|                                              |");
                 System.out.println("|   5. BACK TO MAIN MENU                       |");
                 System.out.println("\\----------------------------------------------/");
                 System.out.print("        Enter your Choice Please: ");
                 ch1=Integer.parseInt(br.readLine( ));
                 switch(ch1)
                 {
                     case 1:
                        a.NewEntry( );
                        break;
                     case 2:
                        a.Delete();
                        break;
                     case 3:
                        a.Return();
                        break;
                     case 4:
                        a.Change();
                        break;
                     case 5:
                        break;
                     default: 
                        System.out.println("Invalid Entry.. Press Enter & Enter Option Again..");
                        br.read();
                 } 
              }
              
              break;
           case 2:
              int ch2=0;
              while (ch2 != 3)
              {
                 a.Clear();
                 System.out.println();
                 System.out.println("------------------------------------------------");
                 System.out.println("|               TRANSACTION MENU               |");
                 System.out.println("|----------------------------------------------|");
                 System.out.println("|   1. ISSUING MEDICINE                        |");
                 System.out.println("|                                              |");
                 System.out.println("|   2. RECIEVE MEDICINE                        |");
                 System.out.println("|                                              |");
                 System.out.println("|   3. Back to Main Menu                       |");
                 System.out.println("\\----------------------------------------------/");
                 System.out.print("        Enter your Choice Please: ");
                 ch2=Integer.parseInt(br.readLine( ));
                 switch(ch2)
                 {
                     case 1:
                        a.Issue( ); 
                        break;
                     case 2:
                        //a.Receive( ); 
                        break;
                     case 3:
                        break;
                     default: 
                        System.out.println("Invalid Entry.. Press Enter & Enter Option Again..");
                        br.readLine();
                        break;
                 }
              }
              break;
           case 3:
              break;
           case 4:
              System.out.println("The System is Developed By");
              System.out.println("Yashasva Pratap Singh");
              break;
           default :
              System.out.println("Invalid Entry.. Press Enter & Enter Option Again..");
              br.readLine();
        }
      }
   }
}