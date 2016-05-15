package application;


import java.util.ArrayList;

public class EqulOpreation
{

   public EqulOpreation(String op)
   {

   }

   private static double calculate(String problem) throws Exception
   {
     ArrayList<String> elements =new ArrayList<String>();
     String temp="";
     int current=0;

       for(int i=0;i<problem.length();i++)
       {//3+4 
           temp=problem.substring(current,i);
           if(problem.toCharArray()[i]=='+'||
              problem.toCharArray()[i]=='-'||
              problem.toCharArray()[i]=='x'||
              problem.toCharArray()[i]=='^'||
               problem.toCharArray()[i]=='%'||
               problem.toCharArray()[i]=='√'||
              problem.toCharArray()[i]=='/')
           {
               elements.add(temp);
               elements.add(problem.substring(i,i+1));
               current=i+1;
           }

       }
       elements.add(problem.substring(current,problem.length()));
       double result=0;
      for(int i=0;i<elements.size();i++)
      {
         if(elements.get(i).equals(""))
         {
             elements.remove(i);
         }
      }
      for(int i=elements.size()-1;i>-1;i--)
      {try
      {
         if(elements.get(i).contains("-"))
         {
             if(elements.get(i+1).contains("√"))
             {
                 result=Math.sqrt(Double.parseDouble(elements.get(i+2)));
                 elements.set(i+1,String.valueOf(result*(-1)));
                 elements.remove(i);
                 elements.remove(i+1);
             }
             else {
                elements.set(i+1,String.valueOf(Double.parseDouble(elements.get(i+1))*(-1)));
             elements.remove(i);
            }
         }}
      catch (Exception ex)
      {
          if(elements.get(i+1).equals("+"))
          {
              elements.remove(i+1);
              i++;
          }

      }
      }
      for(int i=0;i<elements.size();i++)
      {
          try{
         if(Double.parseDouble(elements.get(i))>1||Double.parseDouble(elements.get(i))<2)
             if(Double.parseDouble(elements.get(i+1))>1||Double.parseDouble(elements.get(i+1))<2)
             {
                 elements.set(i+1,String.valueOf(Double.parseDouble(elements.get(i))+Double.parseDouble(elements.get(i+1))));
                 elements.remove(i);
             }

          }
         catch (Exception ex)
           {}
          }
       for(int i=0;i<elements.size();i++)
       {
           if(elements.get(i).equals("%"))
           {  if(Double.parseDouble(elements.get(i+1))<=0)
              throw new Exception("minecan not find mod because of zero!");

               result= Double.parseDouble(elements.get(i-1))%Double.parseDouble(elements.get(i+1));
               elements.set(i-1,String.valueOf(result));
               elements.remove(i);
               elements.remove(i);
               i=i-1;
           }
       }
       for(int i=0;i<elements.size();i++)
       {
           if(elements.get(i).equals("^"))
           {
               result=Math.pow(Double.parseDouble(elements.get(i-1)),Double.parseDouble(elements.get(i+1)));
               elements.set(i-1,String.valueOf(result));
               elements.remove(i);
               elements.remove(i);
               i=i-1;
           }
       }
      for(int i=0;i<elements.size();i++)
      {
          if(elements.get(i).equals("√"))
          {
              if(Double.parseDouble(elements.get(i+1))<0)
                  throw new Exception("minecan not find square root for negative number!");
              result=Math.sqrt(Double.parseDouble(elements.get(i+1)));
              elements.set(i+1,String.valueOf(result));
              elements.remove(i);
              i=i-1;
          }
      }
       for(int i=0;i<elements.size();i++)
       {
           if(elements.get(i).equals("x"))
           {
               result=Double.parseDouble(elements.get(i-1))*Double.parseDouble(elements.get(i+1));
               elements.set(i-1,String.valueOf(result));
               elements.remove(i);
               elements.remove(i);
               i=i-1;
           }
           else if(elements.get(i).equals("/"))
           {
              if(Double.parseDouble(elements.get(i+1))==0)
                  throw new Exception("minecan not divide by zero!");
               result=Double.parseDouble(elements.get(i-1))/Double.parseDouble(elements.get(i+1));
               elements.set(i-1,String.valueOf(result));
               elements.remove(i);
               elements.remove(i);
               i=i-1;
           }

       }
       for(int i=0;i<elements.size();i++)
       {
           if(elements.get(i).equals("+"))
           {
               result=Double.parseDouble(elements.get(i-1))+Double.parseDouble(elements.get(i+1));
               elements.set(i-1,String.valueOf(result));
               elements.remove(i);
               elements.remove(i);
               i=i-1;
           }
           /*else if(elements.get(i).equals("-"))
           {
               result=Double.parseDouble(elements.get(i-1))-Double.parseDouble(elements.get(i+1));
               elements.set(i-1,String.valueOf(result));
               elements.remove(i);
               elements.remove(i);
               i=i-1;
           }*/

       }
       return Double.parseDouble(String.valueOf(elements.get(0)));

   }


   private static void bracketshandler(String exprsseion,ArrayList<String> operations) {
       exprsseion="("+exprsseion+")";
     int countleft=0,countright=0;
     for(int i=0;i<exprsseion.length();i++)
         if(exprsseion.toCharArray()[i]=='(')
             countleft++;
         else
             if(exprsseion.toCharArray()[i]==')')
             countright++;
     if(countleft!=countright) return;
     for(int i=0;i<exprsseion.length();i++)
     {
         if(exprsseion.contains("(")==false)
             return;
         if(exprsseion.toCharArray()[i]=='(')
         {
             for(int j=i+1;j<exprsseion.length();j++)
             {
                 if(exprsseion.toCharArray()[j]=='(')
                     {
                     break;
                     }
                 if(exprsseion.toCharArray()[j]==')')
                 {
                     String operation=exprsseion.substring(i+1,j);
                     operations.add(operation);
                     exprsseion=exprsseion.replace(exprsseion.substring(i,j+1),"op"+(operations.size()-1));
                     break;
                 }
             }
         }
         if(i==exprsseion.length()-1)
             i=-1;
     }
 }

   private  static String replacelog(String e) throws Exception
   {
       int position=e.indexOf("log");
       int end=0;
       int skip=0;
       double result=0;
       if(e.contains("log("))
       {

           for(int i=position+4;i<e.length();i++)
             {
                 if(e.toCharArray()[i]==')'&&skip==0)
                 {
                     end=i;break;
                 }
                 if(e.toCharArray()[i]=='(')
                       skip++;
                 if(e.toCharArray()[i]==')')
                       skip--;
             }
           String temp=e.substring(position+4,end);
           result=getresult(temp);
          if(result<=0)
              throw new Exception("minecan not find log for zero or negative!");
           result=Math.log10(result);
           e=e.replace(e.substring(position, end+1),String.valueOf(result));
       }
     return e;

   }

   public static double getresult(String e) throws Exception {
       e=e.replace("--","+");
       e=e.replace("++","+");
       e=e.replace("//","/");

       while(e.contains("log("))
           e=replacelog(e);

       ArrayList<String> operations=new ArrayList<String>();
       bracketshandler(e,operations);
       for(int i=0;i<operations.size();i++)
       {
           operations.set(i , String.valueOf(calculate(operations.get(i))));
           for(int j=i+1;j<operations.size();j++)
           {
               operations.set(j,operations.get(j).replace("op"+i,operations.get(i)));
           }
       }

     return  Double.parseDouble(operations.get(operations.size()-1));
 }

}
