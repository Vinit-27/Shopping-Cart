package Innovative;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import java.util.concurrent.Flow;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ass {
    public static void main(String[] args) {
        CreateAccount c = new CreateAccount();
        
    }
}
class Frame extends JFrame{
    public Frame(){
    setTitle("Fashion store");
    Image icon = Toolkit.getDefaultToolkit().getImage("Innovative\\png_file\\icon.png");
    setIconImage(icon);
    setLayout(new FlowLayout(FlowLayout.LEADING));
    setVisible(true);
    setSize(1000, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class Home extends Frame {
    JTextField t1;
    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6,b7;
    public Home(){
        JLabel s[] = new JLabel[30]; // for Space

        t1 = new JTextField(60);
        l1 = new JLabel("Search");
        b1 = new JButton("🔍");
        b2 = new JButton("Men's");
        b3 = new JButton("Women's");
        b4 = new JButton("Kids'");
        b5 = new JButton("Perfumes & Spray");
        b6 = new JButton("Cart");
        b7 = new JButton("My Account");

        for(int i=0;i<2;i++){
            s[i]=new JLabel("               ");
            add(s[i]);
        }
        add(l1); add(t1); add(b1); add(b6); add(b7);
        for(int i=2;i<20;i++){
            s[i]=new JLabel("               ");
            add(s[i]);
        }
        add(b2);    add(b3);    add(b4);    add(b5);
        
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Men();
                dispose();
            }
        });
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Women();
                dispose();
            }
        });
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
               String str = t1.getText();
               if(str.equalsIgnoreCase("Men")){
                    new Men();
                    dispose();
               }
               else if(str.equalsIgnoreCase("Women")){
                    new Women();
                    dispose();
               }
               else if(str.equalsIgnoreCase("kid")){
                    new Kids();
                    dispose();
               }
               else if(str.equalsIgnoreCase("Perfume")||str.equalsIgnoreCase("Spray")){
                    new PerfumeAndSpray();
                    dispose();
                }
               else{
                    JOptionPane.showMessageDialog(null,"Item Not found!!");
               }
            }
        });
        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Kids();
                dispose();
            }
        });
        b5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new PerfumeAndSpray();
                dispose();
            }
        });
        b6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Cart();
                dispose();
            }
        });
        b7.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new MyAccount();
                dispose();
            }
        });
    }
}
class CreateAccount extends Frame{
    JTextField t1,t2,t3;
    JPasswordField t4;
    JButton b1,b2;
    public CreateAccount(){
        JLabel s[] = new JLabel[50]; // for Space

        t1=new JTextField(40);
        t2=new JTextField(40);
        t3=new JTextField(40);
        t4=new JPasswordField(40);
        b1=new JButton("Log in");
        b2=new JButton("Create an account");
        JLabel l1=new JLabel("Name:");
        JLabel l2=new JLabel("Mobile number:");
        JLabel l3=new JLabel("Address:");
        JLabel l4=new JLabel("Password:");
        JLabel l5=new JLabel("Already have an account?");

        for(int i=0;i<4;i++){
            s[i]=new JLabel("               ");
            add(s[i]);
        }
        add(l1);add(t1);
        for(int i=4;i<11;i++){
            s[i]=new JLabel("               ");
            add(s[i]);
        }
        add(l2);add(t2);
        add(l3);add(t3);
        s[12]=new JLabel("               ");
        add(s[12]);
        add(l4);add(t4);
        for(int i=13;i<28;i++){
            s[i]=new JLabel("               ");
            add(s[i]);
        }
        add(b2);
        for(int i=28;i<38;i++){
            s[i]=new JLabel("               ");
            add(s[i]);
        }
        add(l5);add(b1);

        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                int msg_type = JOptionPane.PLAIN_MESSAGE;
                try{
                    File fp = new File("Records.txt");
                    FileWriter writer = new FileWriter(fp);
                    writer.write(t1.getText()+"\n");
                    writer.write(t2.getText()+"\n");
                    String str = new String(t4.getPassword());
                    writer.write(str+"\n");
                    writer.write(t3.getText()+"\n");
                    writer.close();
                    JOptionPane.showMessageDialog(null,"Account Created.","GOOD NEWS",msg_type);
                    new Home();
                    dispose();
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        });

        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Login();
                dispose();
            }
        });
    }
}
class Login extends Frame{
    public Login(){
        JTextField t2=new JTextField(40);
        JPasswordField t3=new JPasswordField(40);
        JButton b1=new JButton("Log in");
        JLabel l2=new JLabel("Mobile number:");
        JLabel l4=new JLabel("Password:");

        add(l2);add(t2);
        add(l4);add(t3);
        add(b1);

        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    File fp = new File("Records.txt");
                    Scanner reader = new Scanner(fp);
                    String str[] = new String [4];
                    for(int i=0;i<4;i++)
                        str[i] = reader.nextLine();
                    String str2 = new String(t3.getPassword());
                    if(str[1].equals(t2.getText()) && str[2].equals(str2)){
                        new Home();
                        dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Invalid Credentials!!");
                    }

                    reader.close();
                }
                catch(Exception e){
                    System.out.println(e);
                    JOptionPane.showMessageDialog(null,"Can't find your Account!!\nMake sure that you have made account.");
                    new CreateAccount();
                    dispose();
                }
            }
        });
    }
}
class Men extends Frame{
    public Men(){
        JLabel l1 = new JLabel("Men's");
        JButton b1 = new JButton("Top wear");
        JButton b2 = new JButton("Bottom wear");
        JButton b3 = new JButton("footware");
        JButton b4 = new JButton("Watches");
        JButton b5 = new JButton("Home"); 
        
        b5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Home();
                dispose();
            }
        });
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new TopWearMen();
                dispose();
            }
        });
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new BottomWearMen();
                dispose();
            }
        });
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new FootwareMen();
                dispose();
            }
        });
        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new WatchesMen();
                dispose();
            }
        });
        add(b5);
        add(l1); 
        add(b1);    add(b2);    add(b3);
        add(b4);
    } 
}
class TopWearMen extends Frame{
    public TopWearMen(){
        setLayout(new FlowLayout(FlowLayout.CENTER,15,5));
        ImageIcon I1 = new ImageIcon("Innovative\\png_file\\shirt_men.jpg");
        JButton b1 = new JButton(" shirt Price: Rs.299",I1);
        ImageIcon I2 = new ImageIcon("Innovative\\png_file\\suit.jpg");
        JButton b2 = new JButton(" suit Price: Rs.400",I2);
        ImageIcon I3 = new ImageIcon("Innovative\\png_file\\T-shirt.jpg");
        JButton b3 = new JButton(" T-shirt Price: Rs.399",I3);
        ImageIcon I4 = new ImageIcon("Innovative\\png_file\\jaket.jpeg");
        JButton b4 = new JButton(" jaket Price: Rs.406",I4);
        JButton b = new JButton("Home");
        add(b);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        int msg_type = JOptionPane.PLAIN_MESSAGE;
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Home();
                dispose();
            }
        });
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Addcart c = new Addcart();
                c.addData(b1);
                JOptionPane.showMessageDialog(null,"Item added into cart.","Message",msg_type);
            }
        });
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Addcart c = new Addcart();
                c.addData(b2);
                JOptionPane.showMessageDialog(null,"Item added into cart.","Message",msg_type);
            }
        });
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Addcart c = new Addcart();
                c.addData(b3);
                JOptionPane.showMessageDialog(null,"Item added into cart.","Message",msg_type);
            }
        });
        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Addcart c = new Addcart();
                c.addData(b4);
                JOptionPane.showMessageDialog(null,"Item added into cart.","Message",msg_type);
            }
        });
    }
}
class BottomWearMen extends Frame{
    public BottomWearMen(){
        setLayout(new FlowLayout(FlowLayout.CENTER,15,5));
        ImageIcon I1 = new ImageIcon("Innovative\\png_file\\trouser.jpg");
        JButton b1 = new JButton(" Trouser Price: Rs.213",I1);
        ImageIcon I2 = new ImageIcon("Innovative\\png_file\\jeanse.jpg");
        JButton b2 = new JButton(" Pant Price: Rs.415",I2);
        JButton b = new JButton("Home");
        add(b);
        add(b1);
        add(b2);
        int msg_type = JOptionPane.PLAIN_MESSAGE;
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Home();
                dispose();
            }
        });
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Addcart c = new Addcart();
                c.addData(b1);
                JOptionPane.showMessageDialog(null,"Item added into cart.","Message",msg_type);
            }
        });
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Addcart c = new Addcart();
                c.addData(b2);
                JOptionPane.showMessageDialog(null,"Item added into cart.","Message",msg_type);
            }
        });
    }
}
class FootwareMen extends Frame{
    public FootwareMen(){
        setLayout(new FlowLayout(FlowLayout.CENTER,15,5));
        ImageIcon I1 = new ImageIcon("Innovative\\png_file\\f1.jpg");
        JButton b1 = new JButton(" Party Shoe Price: Rs.599",I1);
        ImageIcon I2 = new ImageIcon("Innovative\\png_file\\f2.jpg");
        JButton b2 = new JButton(" Sports Shoe Price: Rs.499",I2);
        ImageIcon I3 = new ImageIcon("Innovative\\png_file\\f3.jpg");
        JButton b3 = new JButton(" Flite Slipper Price: Rs.199",I3);
        JButton b = new JButton("Home");
        add(b);
        
        add(b1);
        add(b2);
        add(b3);
        int msg_type = JOptionPane.PLAIN_MESSAGE;
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Home();
                dispose();
            }
        });
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Addcart c = new Addcart();
                c.addData(b1);
                JOptionPane.showMessageDialog(null,"Item added into cart.","Message",msg_type);
            }
        });
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Addcart c = new Addcart();
                c.addData(b2);
                JOptionPane.showMessageDialog(null,"Item added into cart.","Message",msg_type);
            }
        });
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Addcart c = new Addcart();
                c.addData(b3);
                JOptionPane.showMessageDialog(null,"Item added into cart.","Message",msg_type);
            }
        });
    }
}
class WatchesMen extends Frame{
    public WatchesMen(){
        setLayout(new FlowLayout(FlowLayout.CENTER,15,5));
        ImageIcon I1 = new ImageIcon("Innovative\\png_file\\w1.jpg");
        JButton b1 = new JButton(" Analog Watch Price: Rs.499",I1);
        ImageIcon I2 = new ImageIcon("Innovative\\png_file\\w2.jpg");
        JButton b2 = new JButton(" Smart Watch Price: Rs.2499",I2);
        JButton b = new JButton("Home");
        add(b);

        add(b1);
        add(b2);
        int msg_type = JOptionPane.PLAIN_MESSAGE;
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Home();
                dispose();
            }
        });
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Addcart c = new Addcart();
                c.addData(b1);
                JOptionPane.showMessageDialog(null,"Item added into cart.","Message",msg_type);
            }
        });
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Addcart c = new Addcart();
                c.addData(b2);
                JOptionPane.showMessageDialog(null,"Item added into cart.","Message",msg_type);
            }
        });
    }
}
class Women extends Frame{
    public Women(){
        JLabel l1 = new JLabel("Women's");
        JButton b1 = new JButton("Top wear");
        JButton b2 = new JButton("Bottom wear");
        JButton b3 = new JButton("Footware");
        JButton b5 = new JButton("Home"); 
        b5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Home();
                dispose();
            }
        });

        add(b5);
        add(l1); 
        add(b1);    add(b2);    add(b3);

        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new TopWearWomen();
                dispose();
            }
        });
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new BottomWearWomen();
                dispose();
            }
        });
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new FootwareWomen();
                dispose();
            }
        });
    } 
}
class TopWearWomen extends Frame{
    public TopWearWomen(){
        setLayout(new FlowLayout(FlowLayout.CENTER,15,5));
        ImageIcon I1 = new ImageIcon("Innovative\\png_file\\wo1.jpg");
        JButton b1 = new JButton(" Designer Dress Price: Rs.699",I1);
        ImageIcon I2 = new ImageIcon("Innovative\\png_file\\wo2.jpg");
        JButton b2 = new JButton(" Dress Price: Rs.599",I2);
        ImageIcon I3 = new ImageIcon("Innovative\\png_file\\wo3.jpg");
        JButton b3 = new JButton(" Western Shirt Price: Rs.499",I3);
        JButton b = new JButton("Home");
        add(b);
        add(b1); add(b2); add(b3);
        int msg_type = JOptionPane.PLAIN_MESSAGE;
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Home();
                dispose();
            }
        });
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Addcart c = new Addcart();
                c.addData(b1);
                JOptionPane.showMessageDialog(null,"Item added into cart.","Message",msg_type);
            }
        });
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Addcart c = new Addcart();
                c.addData(b2);
                JOptionPane.showMessageDialog(null,"Item added into cart.","Message",msg_type);
            }
        });
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Addcart c = new Addcart();
                c.addData(b3);
                JOptionPane.showMessageDialog(null,"Item added into cart.","Message",msg_type);
            }
        });
    }
}
class BottomWearWomen extends Frame{
    public BottomWearWomen(){
        setLayout(new FlowLayout(FlowLayout.CENTER,15,5));
        ImageIcon I1 = new ImageIcon("Innovative\\png_file\\wb1.jpg");
        JButton b1 = new JButton("Plaza Price: Rs.399",I1);
        ImageIcon I2 = new ImageIcon("Innovative\\png_file\\wb3.jpg");
        JButton b2 = new JButton("Track Pant Price: Rs.299",I2);
        ImageIcon I3 = new ImageIcon("Innovative\\png_file\\wb2.jpg");
        JButton b3 = new JButton("Women pant Price: Rs.349",I3);
        JButton b = new JButton("Home");
        add(b);
        add(b1); add(b2); add(b3);
        int msg_type = JOptionPane.PLAIN_MESSAGE;
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Home();
                dispose();
            }
        });
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Addcart c = new Addcart();
                c.addData(b1);
                JOptionPane.showMessageDialog(null,"Item added into cart.","Message",msg_type);
            }
        });
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Addcart c = new Addcart();
                c.addData(b2);
                JOptionPane.showMessageDialog(null,"Item added into cart.","Message",msg_type);
            }
        });
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Addcart c = new Addcart();
                c.addData(b3);
                JOptionPane.showMessageDialog(null,"Item added into cart.","Message",msg_type);
            }
        });
    }
}
class FootwareWomen extends Frame{
    public FootwareWomen(){
        setLayout(new FlowLayout(FlowLayout.CENTER,15,5));
        ImageIcon I1 = new ImageIcon("Innovative\\png_file\\wf1.jpg");
        JButton b1 = new JButton(" Black Sandal Price: Rs.499",I1);
        ImageIcon I2 = new ImageIcon("Innovative\\png_file\\wf2.jpg");
        JButton b2 = new JButton(" Red Shoe Price: Rs.699",I2);
        ImageIcon I3 = new ImageIcon("Innovative\\png_file\\wf3.jpg");
        JButton b3 = new JButton(" Sandal Price: Rs.399",I3);
        JButton b = new JButton("Home");
        add(b);

        add(b1); add(b2); add(b3);
        int msg_type = JOptionPane.PLAIN_MESSAGE;
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Home();
                dispose();
            }
        });
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Addcart c = new Addcart();
                c.addData(b1);
                JOptionPane.showMessageDialog(null,"Item added into cart.","Message",msg_type);
            }
        });
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Addcart c = new Addcart();
                c.addData(b2);
                JOptionPane.showMessageDialog(null,"Item added into cart.","Message",msg_type);
            }
        });
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Addcart c = new Addcart();
                c.addData(b3);
                JOptionPane.showMessageDialog(null,"Item added into cart.","Message",msg_type);
            }
        });
    }
}
class Cart extends Frame{
    
    public Cart(){
        setLayout(new FlowLayout(FlowLayout.LEFT,15,5));
        JButton b1 = new JButton("Home");
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Home();
                dispose();
            }
        });
        add(b1);
        JButton check = new JButton("Check out");
        add(check);
        JLabel spacex[]=new JLabel[5];
            for(int j=0;j<5;j++){
                spacex[j]=new JLabel("   ");
                add(spacex[j]);
            }
        JLabel l1 = new JLabel("Cart Items are as follows: ");
        add(l1);

        JLabel l[] = new JLabel[37];
        try{
            File fp = new File("itemdata.txt");
            Scanner reader = new Scanner(fp);
            
            int i=0;
            while(reader.hasNextLine()){
                l[i] = new JLabel(reader.nextLine());
                add(l[i]);
                i++;
            }
            reader.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        try{
            File fp = new File("cartdata.txt");
            Scanner reader = new Scanner(fp);
            JLabel l2 = new JLabel("TOTAL: "+reader.next());
            add(l2);
            reader.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        int msg_type = JOptionPane.PLAIN_MESSAGE;
        check.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                JOptionPane.showMessageDialog(null,"Your order Placed.","Thank you for shoping",msg_type);
                try {
                    File fp = new File("cartdata.txt");
                    FileWriter w = new FileWriter(fp);
                    w.write("0");
                    w.close();
                    File f = new File("itemdata.txt");
                    FileWriter w1 = new FileWriter(f);
                    w1.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
                new Home();
                dispose();
            }
        });
    }
}
class MyAccount extends Frame{
    public MyAccount(){
        String str[] = new String [4];
        try{
            File fp = new File("Records.txt");
            Scanner reader = new Scanner(fp);
            
            for(int i=0;i<4;i++)
                str[i] = reader.nextLine();
    
            reader.close();
        }
        catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Data not Found!!");
        }
        JButton b1 = new JButton("Home");
        JLabel l1 = new JLabel("Name: ");
        JLabel l2 = new JLabel(str[0]);
        JLabel l3 = new JLabel("Mobile No: ");
        JLabel l4 = new JLabel(str[1]);
        JLabel l5 = new JLabel("Address: ");
        JLabel l6 = new JLabel(str[3]);
        add(b1);
        add(l1);add(l2);
        add(l3);add(l4);
        add(l5);add(l6);

        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Home();
                dispose();
            }
        });
    }
}
class PerfumeAndSpray extends Frame{
    public PerfumeAndSpray(){
        JButton b=new JButton("Home");
        add(b);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Home();
                dispose();
            }
        });
        JLabel l1=new JLabel("Perfumes and Sprays: ");
       
        JLabel space[]=new JLabel[5];
        for(int i=0;i<5;i++){
            space[i]=new JLabel("   ");
            add(space[i]);
        }
   
        JButton b1=new JButton("Deo");
        b1.addActionListener(new ActionListener(){
         
            public void actionPerformed(ActionEvent ae){
                new Deo();
                dispose();
            } 
        });
        JButton b2=new JButton("Perfumes");
        b2.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent ae){
                new Perfume();
                dispose();
            }
        });
   
        add(b1);
        for(int i=0;i<5;i++){
            space[i]=new JLabel("   ");
            add(space[i]);
        }
        add(b2);  
    }
}  
class Perfume extends Frame{
    public Perfume(){
        setLayout(new FlowLayout(FlowLayout.CENTER,15,5));
        JButton b = new JButton("Home");
        add(b);
        ImageIcon i1=new ImageIcon("Innovative\\png_file\\Denver.jpeg");
        JButton b1=new JButton("Denver Price: Rs.149",i1);
        add(b1);
        ImageIcon i2=new ImageIcon("Innovative\\png_file\\Cobra.jpeg");
        JButton b2=new JButton("Cobra Price: Rs.169",i2);
        add(b2);
        ImageIcon i3=new ImageIcon("Innovative\\png_file\\Parkavenue.jpeg");
        JButton b3=new JButton("Park Avenue Price: Rs.229",i3);
        add(b3);
        int msg_type = JOptionPane.PLAIN_MESSAGE;
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Home();
                dispose();
            }
        });
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Addcart c = new Addcart();
                c.addData(b1);
                JOptionPane.showMessageDialog(null,"Item added into cart.","Message",msg_type);
            }
        });
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Addcart c = new Addcart();
                c.addData(b2);
                JOptionPane.showMessageDialog(null,"Item added into cart.","Message",msg_type);
            }
        });
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Addcart c = new Addcart();
                c.addData(b3);
                JOptionPane.showMessageDialog(null,"Item added into cart.","Message",msg_type);
            }
        });
    }
}
class Deo extends Frame{
    public Deo(){
        setLayout(new FlowLayout(FlowLayout.CENTER,15,5));
        JButton b = new JButton("Home");
        add(b);
        ImageIcon i1=new ImageIcon("Innovative\\png_file\\Axe.jpeg");
        JButton b1=new JButton("AXE Price: Rs.149",i1);
        add(b1);
        ImageIcon i2=new ImageIcon("Innovative\\png_file\\Fogg.jpeg");
        JButton b2=new JButton("Fogg Price: Rs.189",i2);
        add(b2);
        ImageIcon i3=new ImageIcon("Innovative\\png_file\\Wildstone.jpeg");
        JButton b3=new JButton("WILD STONE Price: Rs.219",i3);
        add(b3);
        int msg_type = JOptionPane.PLAIN_MESSAGE;
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Home();
                dispose();
            }
        });
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Addcart c = new Addcart();
                c.addData(b1);
                JOptionPane.showMessageDialog(null,"Item added into cart.","Message",msg_type);
            }
        });
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Addcart c = new Addcart();
                c.addData(b2);
                JOptionPane.showMessageDialog(null,"Item added into cart.","Message",msg_type);
            }
        });
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Addcart c = new Addcart();
                c.addData(b3);
                JOptionPane.showMessageDialog(null,"Item added into cart.","Message",msg_type);
            }
        });
    }
}
class Kids extends Frame{
    public Kids(){
        JButton b=new JButton("Home");
        JLabel l1=new JLabel("Kids'");
        add(b);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Home();
                dispose();
            }
        });
        JButton b1=new JButton("T-shirts");
        ActionListener tshirt=new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    new TShirts();
                    dispose();
                }
        };
        b1.addActionListener(tshirt);
     
        JButton b2=new JButton("Pants");
        ActionListener pants=new ActionListener(){
        public void actionPerformed(ActionEvent ae){
            new Pants();
            dispose();
        }
    };
    b2.addActionListener(pants);  
        JButton b3=new JButton("Footwares");
        ActionListener footwear=new ActionListener(){
        public void actionPerformed(ActionEvent ae){
            new Footwears();
            dispose();
        }
    };
    b3.addActionListener(footwear);
      
  
        JLabel space[]=new JLabel[5];
        add(l1);
        for(int i=0;i<5;i++){
          space[i]=new JLabel("   ");
          add(space[i]);
        }
        add(b1);
        add(b2);add(b3); 
    }
}
class TShirts extends Frame{
    public TShirts(){
        JButton b=new JButton("Home");
        add(b);
        ImageIcon i1=new ImageIcon("Innovative\\png_file\\t-shirt_1.jpeg");
        JButton b1=new JButton("White T-shirt Price: Rs.399",i1);
        ImageIcon i2=new ImageIcon("Innovative\\png_file\\t-shirt_2.jpeg");
        JButton b2=new JButton("Black T-shirt Price: Rs.699",i2);
        ImageIcon i3=new ImageIcon("Innovative\\png_file\\t-shirt_3.jpeg");
        JButton b3=new JButton("Red T-shirt Price: Rs.499",i3);
    
        add(b1);add(b2);add(b3);
        int msg_type = JOptionPane.PLAIN_MESSAGE;
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Home();
                dispose();
            }
        });
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Addcart c = new Addcart();
                c.addData(b1);
                JOptionPane.showMessageDialog(null,"Item added into cart.","Message",msg_type);
            }
        });
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Addcart c = new Addcart();
                c.addData(b2);
                JOptionPane.showMessageDialog(null,"Item added into cart.","Message",msg_type);
            }
        });
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Addcart c = new Addcart();
                c.addData(b3);
                JOptionPane.showMessageDialog(null,"Item added into cart.","Message",msg_type);
            }
        });
    }
}
class Pants extends Frame{
    public Pants(){
        JButton b=new JButton("Home");
        add(b);
        ImageIcon i1=new ImageIcon("Innovative\\png_file\\pant_1.jpeg");
        JButton b1=new JButton("Combo pant 3 Price: Rs.1299",i1);
        ImageIcon i2=new ImageIcon("Innovative\\png_file\\pant_2.jpeg");
        JButton b2=new JButton("Combo pant 2 Price: Rs.899",i2);
        ImageIcon i3=new ImageIcon("Innovative\\png_file\\pant_3.jpeg");
        JButton b3=new JButton("Pant  Price: Rs.499",i3);
    
        add(b1);add(b2);add(b3);
        int msg_type = JOptionPane.PLAIN_MESSAGE;
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Home();
                dispose();
            }
        });
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Addcart c = new Addcart();
                c.addData(b1);
                JOptionPane.showMessageDialog(null,"Item added into cart.","Message",msg_type);
            }
        });
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Addcart c = new Addcart();
                c.addData(b2);
                JOptionPane.showMessageDialog(null,"Item added into cart.","Message",msg_type);
            }
        });
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Addcart c = new Addcart();
                c.addData(b3);
                JOptionPane.showMessageDialog(null,"Item added into cart.","Message",msg_type);
            }
        });
    }
}
class Footwears extends Frame{
    public Footwears(){
        JButton b=new JButton("Home");
        add(b);
        ImageIcon i1=new ImageIcon("Innovative\\png_file\\shoes_1.jpeg");
        JButton b1=new JButton("Blue shoes Price: Rs.399",i1);
        ImageIcon i2=new ImageIcon("Innovative\\png_file\\shoes_2.jpeg");
        JButton b2=new JButton("Loffar Price: Rs.699",i2);
        ImageIcon i3=new ImageIcon("Innovative\\png_file\\shoes_3.jpeg");
        JButton b3=new JButton("Sandal Price: Rs.299",i3);
        
        add(b1);add(b2);add(b3);
        int msg_type = JOptionPane.PLAIN_MESSAGE;
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Home();
                dispose();
            }
        });
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Addcart c = new Addcart();
                c.addData(b1);
                JOptionPane.showMessageDialog(null,"Item added into cart.","Message",msg_type);
            }
        });
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Addcart c = new Addcart();
                c.addData(b2);
                JOptionPane.showMessageDialog(null,"Item added into cart.","Message",msg_type);
            }
        });
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Addcart c = new Addcart();
                c.addData(b3);
                JOptionPane.showMessageDialog(null,"Item added into cart.","Message",msg_type);
            }
        });
    }
}
class Addcart{
    public void addData(JButton b){
        try{
            File f = new  File("cartdata.txt");
            Scanner sc =  new Scanner(f);
            File fp = new File("itemdata.txt");
            
            int total = Integer.parseInt(sc.nextLine());
            sc.close();
            FileWriter wr = new FileWriter(f);
            String str = b.getText();
            FileWriter wr1 = new FileWriter(fp,true); 
            str=str.trim();
            wr1.write(str+"\n");
            wr1.close();
            int idx = str.indexOf("Rs.");
            String price = str.substring(idx+3);
            total += Integer.parseInt(price);
            wr.write(total+"");
            wr.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}