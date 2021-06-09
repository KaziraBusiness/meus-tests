/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *@author Edvalter Jamba
 * 220446571
 * Assignment3
 */
public class RunFiles {
    
    //Here I started to declare my array
    CreateStakeholderSer Stake;
    CreateStakeholderSer[] StakeholderSer =new CreateStakeholderSer[11];
    //Supplier array  //customer  and supplier objects STORED in separate arraylists.
     Supplier[] supplierarray= new Supplier[5];
     //Costumer array //customer  and supplier objects STORED in separate arraylists.
     Customer[] customerarray= new Customer[6];
     
     //ObjectOutputStream So I will be able to make the dat in the arry into the file that it wil create
    private ObjectOutputStream output;
    
     private ObjectInputStream input;
    
    //customer  and supplier objects STORED in separate arraylists.
     public void populatesupplierArray()
    {
    supplierarray[0]= new Supplier("S270", "Grand Theft Auto", "Toyota", "Mid-size sedan");
    supplierarray[1]= new Supplier("S400", "Prime Motors", "Lexus", "Luxury sedan");
    supplierarray[2]= new Supplier("S300", "We got Cars", "Toyota", "10-seater minibus");
    supplierarray[3]= new Supplier("S350", "Auto Delight", "BMW", "Luxury SUV");
    supplierarray[4]= new Supplier("S290", "MotorMania", "Hyundai", "compact budget");
    }
    
      //customer  and supplier objects STORED in separate arraylists.
     public void populateArray()
    {
    customerarray[0]= new Customer("C150", "Luke", "Atmyass", "Bellville", "1981-01-27", 1520.50, false);
    customerarray[1]= new Customer("C130", "Stu", "Padassol", "Sea Point", "1987-05-18", 645.25, true);
    customerarray[2]= new Customer("C100", "Mike", "Rohsopht", "Bellville", "1993-01-24", 975.10, true);
    customerarray[3]= new Customer("C300", "Ivana.B", "Withew", "Langa", "1998-07-16", 1190.50, false);
    customerarray[4]= new Customer("C250", "Eileen", "Sideways", "Nyanga", "1999-11-27", 190.85, true);
    customerarray[5]= new Customer("C260", "Ima", "Stewpidas", "Atlantis", "2001-01-27", 1890.70, true);
    }
   
        public void openFile(){
        try
        {
            //here will create the filecustomerOutFile
            //Costumer //customer  and supplier objects STORED in separate arraylists.
            //I had already stored the customer information in the array now,I will create the file called customerOutFile
            //and get the data stored in the array into the file being created. 
            output = new ObjectOutputStream( new FileOutputStream( "customerOutFile" ) ); 
            System.out.println("\n*** customerOutFile.txt file created and opened for writing ***\n");  
            
            //here will write the data in the array into the file
             for(int i=0;i<customerarray.length;i++)
         {
             output.writeObject(customerarray[i]);
             //Collections.sort(customerarray);
             System.out.println("object "+i+" written to customer.txt file:\n");
            
         } 
              //Supplier
              //here will create the supplierOutFile
             //I had already stored the supplier information in the array now,I will create the file called supplierOutFile
            //and get the data stored in the array into the file being created. 
            output = new ObjectOutputStream( new FileOutputStream( "supplierOutFile" ) ); 
            System.out.println("\n*** supplierOutFile.txt file created and opened for writing ***\n"); 
            
             //here will write the data in the array into the file
             for(int i=0;i<supplierarray.length;i++)
         {
             output.writeObject(supplierarray[i]);
             System.out.println("\n object "+i+" written to supplierOutFile.txt file:\n");
            
         } 
            
     }
        catch (IOException ioe){
            System.out.println("error opening ser file: " + ioe.getMessage());
            System.exit(1);
        }
        try{
        output.close( ); 
        }
        catch (IOException ioe){            
            System.out.println("error closing  file: " + ioe.getMessage());
            System.exit(1);
        }        
   
    }
 
   public void readfromFile()
    {
    
        try
        {
          
            //here will Read the values from filecustomerOutFile
            //Costumer //customer  and supplier objects STORED in separate arraylists.
            //I had already stored the customer information in the array now,I will create the file called customerOutFile
            //and get the data stored in the array into the file being created. 
            input = new ObjectInputStream( new FileInputStream( "customerOutFile" ) ); 
          System.out.println("\n***Sample customer text-file output: opened for Reading ***\n"); 
            
          for(int i=0;i<customerarray.length;i++)
         {
             customerarray[i]=(Customer)input.readObject();
             System.out.println(customerarray[i]);
         } 
            //Supplier
           //here will Read the values from the supplierOutFile
            //I had already stored the supplier information in the array now,I will create the file called supplierOutFile
            //and get the data stored in the array into the file being created.
             input = new ObjectInputStream( new FileInputStream( "supplierOutFile" ) ); 
            System.out.println("\n*** Sample supplier text-file output: opened for Reading ***\n");
            
         for(int i=0;i<supplierarray.length;i++)
         {
             supplierarray[i]=(Supplier)input.readObject();
             System.out.println(supplierarray[1]);
         } 
        
      }
        
         catch(ClassNotFoundException ioe)
       {
        System.out.println("class error reading file: " + ioe);
         
       }
        catch (IOException ioe)
        {
            System.out.println("error opening file: " + ioe);
        }   
       finally
       {
        try
        {
        input.close( ); 
        }
        catch (IOException ioe){            
            System.out.println("***file has been closed***");
           System.exit(1);
        }        
       
       }
        
    }
  
 public static void main(String args[])  {
       RunFiles obj = new RunFiles();
       obj.populateArray();
       obj.populatesupplierArray();
       obj.readfromFile();
   
       obj.openFile();
       
       
    }//end main    
    
    
    
    
    
    
    
}
