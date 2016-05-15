package application;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
public class Main extends Application
{
    boolean clear=true;
 static double widthlistner,heightlistner,result;
Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,pluse,del,c,mince,mul,div,mod,equl,log,openp,closep,squer,root,dot;
    String lineSeparator = System.getProperty("line.separator");
    double btnwidth;
    double btnheight;
    @Override
    public void start(Stage primaryStage) throws Exception
    {

        Rectangle2D rect=Screen.getPrimary().getVisualBounds();
        widthlistner=rect.getWidth();//widthlistner=800;
        heightlistner=rect.getHeight();	//heightlistner=800;
        btnwidth=(widthlistner-35)/6;
        btnheight=(heightlistner-30)/6.5;
        TextField test=new TextField();
        test.setPrefWidth(widthlistner-btnwidth);

        int x=test.getAnchor();
        Label t1= new Label("");
            //t1.setEditable(false);
            t1.setStyle("-fx-font-family:Arial;-fx-font-size:2.5em;");
               new Thread(new Runnable() {
                @Override
                public void run() {
                try {
                while (true) {
                    if(t1.getText().length()>test.getPrefColumnCount()&&!t1.getText().contains(lineSeparator))
                        t1.setStyle("-fx-font-family:Arial;-fx-font-size:1.5em;;");
                    else t1.setStyle("-fx-font-family:Arial;-fx-font-size:3.5em;;");
                Platform.runLater(new Runnable() { // Run from JavaFX GUI
                @Override
                public void run() {
                    if(t1.getText().length()>test.getPrefColumnCount()&&!t1.getText().contains(lineSeparator))
                        t1.setStyle("-fx-font-family:Arial;-fx-font-size:1.5em;;");
                    else t1.setStyle("-fx-font-family:Arial;-fx-font-size:3.5em;;");
                }
                });

                Thread.sleep(50);
                }
                }
                catch (InterruptedException ex) {
                }
                }
                }).start();

            b0=new Button("0");b0.setOnAction(e->
            {
                if(clear)
                    {t1.setText("");clear=false;}
                t1.setText(t1.getText()+"0");



            });
            b1=new Button("1");b1.setOnAction(e->{
            if(clear)
            {t1.setText("");clear=false;}
                t1.setText(t1.getText()+"1");});
            b2=new Button("2");b2.setOnAction(e->{
                if(clear)
                    {t1.setText("");clear=false;}
                t1.setText(t1.getText()+"2");

            });
            b3=new Button("3");b3.setOnAction(e->{
                if(clear)
                    {t1.setText("");clear=false;}
                t1.setText(t1.getText()+"3");

                });
            b4=new Button("4");b4.setOnAction(e->{
                if(clear)
                {t1.setText("");clear=false;}
                t1.setText(t1.getText()+"4");});
            b5=new Button("5");b5.setOnAction(e->{
                if(clear)
                {t1.setText("");clear=false;}
                t1.setText(t1.getText()+"5");});
            b6=new Button("6");b6.setOnAction(e->{
                if(clear)
                {t1.setText("");clear=false;}
                t1.setText(t1.getText()+"6");});
            b7=new Button("7");b7.setOnAction(e->{
                if(clear)
                {t1.setText("");clear=false;}
                t1.setText(t1.getText()+"7");});

            b8=new Button("8");b8.setOnAction(e->{
                if(clear)
                {t1.setText("");clear=false;}
                t1.setText(t1.getText()+"8");});
            b9=new Button("9");b9.setOnAction(e->{
                if(clear)
                {t1.setText("");clear=false;}
                t1.setText(t1.getText()+"9");
                });
            pluse=new Button("+");
            pluse.setOnAction(e->{
                if(clear)
                {t1.setText(String.valueOf(result));clear=false;}
                t1.setText(t1.getText()+"+");});
            mince=new Button("-");
            mince.setOnAction(e->{
            if(clear)
            {t1.setText(String.valueOf(result));clear=false;}
                t1.setText(t1.getText()+"-");});
            div=new Button("/");
            div.setOnAction(e->{
                if(clear)
                {t1.setText(String.valueOf(result));clear=false;}
                t1.setText(t1.getText()+"/");});
            mul=new Button("x");
            mul.setOnAction(e->{
                if(clear)
                {t1.setText(String.valueOf(result));clear=false;}
                t1.setText(t1.getText()+"x");});
            mod=new Button("%");
            mod.setOnAction(e->{
                if(clear)
                {t1.setText(String.valueOf(result));clear=false;}
                t1.setText(t1.getText()+"%");});
            c = new Button("C");
            c.setOnAction(e->{
                t1.setText("");});
            del=new Button("<-");
            del.setOnAction(e->{
                if(t1.getText().equals(""))
                {
                    t1.setText("");
                }
                else if(t1.getText().toCharArray()[t1.getText().toCharArray().length-1]=='('&&t1.getText().toCharArray()[t1.getText().toCharArray().length-2]=='g')
                {
                     String temp=t1.getText().substring(0,t1.getText().length()-4);
                     t1.setText(temp);
                }
                else if(t1.getText().toCharArray()[t1.getText().toCharArray().length-1]=='('&&t1.getText().toCharArray()[t1.getText().toCharArray().length-2]=='t')
                {
                     String temp=t1.getText().substring(0,t1.getText().length()-5);
                     t1.setText(temp);
                }

                else{
                String temp=t1.getText().substring(0,t1.getText().length()-1);
                t1.setText(temp);}
                ;});
            equl=new Button("=");
            equl.setOnAction(e->
            {
                try{
                    result=EqulOpreation.getresult(t1.getText());
                t1.setText(t1.getText()+lineSeparator+String.valueOf(result));
                clear=true;
                }catch(Exception ex)
                {
                    if(ex.getMessage().contains("mine"))
                        t1.setText(ex.getMessage().replace("mine",""));
                    else t1.setText("invalid input!");
                    clear=true;

                }
                });
            log=new Button("log");
            log.setOnAction(e->{
                if(clear)
                {t1.setText("log("+String.valueOf(result)+")");clear=false;}
                else t1.setText(t1.getText()+"log(");});
            openp=new Button("(");
            openp.setOnAction(e->{
                if(clear)
                {t1.setText("");clear=false;}
                t1.setText(t1.getText()+"(");});
            closep=new Button(")");
            closep.setOnAction(e->{
                if(clear)
                {t1.setText("");clear=false;}
                t1.setText(t1.getText()+")");});
            squer=new Button("^");
            squer.setOnAction(e->{
                if(clear)
                {t1.setText(String.valueOf(result));clear=false;}
                t1.setText(t1.getText()+"^");});
            root=new Button("√");
            root.setOnAction(e->{
                if(clear)
                {t1.setText("√"+String.valueOf(result));clear=false;}
                else  t1.setText(t1.getText()+"√");});
            dot=new Button(".");
            dot.setOnAction(e->{
                if(clear)
                {t1.setText(String.valueOf(result));clear=false;}
                t1.setText(t1.getText()+".");});
            Pane pane=new Pane();
               HBox text=new HBox();
            pane.getChildren().addAll(text,b7,b8,b9,c,log,div,b4,b5,b6,mul,openp,closep,b1,b2,b3,mince,squer,root,b0,dot,mod,pluse,equl);
            text.setPrefSize(widthlistner,2*heightlistner/6);

            t1.setPrefSize(btnwidth*5+20,2*btnheight);
               c.setPrefSize(btnwidth,btnheight);
               del.setPrefSize(btnwidth,2*btnheight);
               b7.setPrefSize(btnwidth,btnheight);
               b6.setPrefSize(btnwidth,btnheight);
               b5.setPrefSize(btnwidth,btnheight);
               b4.setPrefSize(btnwidth,btnheight);
               b3.setPrefSize(btnwidth,btnheight);
               b2.setPrefSize(btnwidth,btnheight);
               b1.setPrefSize(btnwidth,btnheight);
               b0.setPrefSize(btnwidth,btnheight);
               b8.setPrefSize(btnwidth,btnheight);
               b9.setPrefSize(btnwidth,btnheight);
               log.setPrefSize(btnwidth,btnheight);
               div.setPrefSize(btnwidth,btnheight);
               mul.setPrefSize(btnwidth,btnheight);
               openp.setPrefSize(btnwidth,btnheight);
               closep.setPrefSize(btnwidth,btnheight);
               mince.setPrefSize(btnwidth,btnheight);
               root.setPrefSize(btnwidth,btnheight);
               equl.setPrefSize(btnwidth*2+5,btnheight);
               pluse.setPrefSize(btnwidth,btnheight);
               mod.setPrefSize(btnwidth,btnheight);
               squer.setPrefSize(btnwidth,btnheight);
               dot.setPrefSize(btnwidth,btnheight);
               text.relocate(0,0);
               b7.relocate(5,2*btnheight+10);
               b4.relocate(5,3*btnheight+15);
               b1.relocate(5,4*btnheight+20);
               b0.relocate(5,5*btnheight+25);
               b8.relocate(10+btnwidth,2*btnheight+10);
               b5.relocate(10+btnwidth,3*btnheight+15);
               b2.relocate(10+btnwidth,4*btnheight+20);
               dot.relocate(10+btnwidth,5*btnheight+25);
               b9.relocate(15+btnwidth*2,2*btnheight+10);
               b6.relocate(15+btnwidth*2,3*btnheight+15);
               b3.relocate(15+btnwidth*2,4*btnheight+20);
               mod.relocate(15+btnwidth*2,5*btnheight+25);
               div.relocate(20+btnwidth*3,2*btnheight+10);
               mince.relocate(20+btnwidth*3,3*btnheight+15);
               mul.relocate(20+btnwidth*3,4*btnheight+20);
               pluse.relocate(20+btnwidth*3,5*btnheight+25);
               c.relocate(25+4*btnwidth,2*btnheight+10);
               openp.relocate(25+4*btnwidth,3*btnheight+15);
               squer.relocate(25+4*btnwidth,4*btnheight+20);
               equl.relocate(25+4*btnwidth,5*btnheight+25);
               log.relocate(30+5*btnwidth,2*btnheight+10);
               closep.relocate(30+5*btnwidth,3*btnheight+15);
               root.relocate(30+5*btnwidth,4*btnheight+20);

               Scene scene = new Scene(pane,widthlistner,heightlistner);
               text.getChildren().addAll(t1,del);
              primaryStage.widthProperty().addListener(ov ->
                  {
                      heightlistner=primaryStage.getHeight();
                      widthlistner=primaryStage.getWidth();
                        text.setPrefSize(widthlistner,2*heightlistner/6);
                         btnwidth=(widthlistner-35)/6;
                         btnheight=(heightlistner-30)/6.5;
                        t1.setPrefSize(btnwidth*5+20,2*btnheight);
                           c.setPrefSize(btnwidth,btnheight);
                           del.setPrefSize(btnwidth,2*btnheight);
                           b7.setPrefSize(btnwidth,btnheight);
                           b6.setPrefSize(btnwidth,btnheight);
                           b5.setPrefSize(btnwidth,btnheight);
                           b4.setPrefSize(btnwidth,btnheight);
                           b3.setPrefSize(btnwidth,btnheight);
                           b2.setPrefSize(btnwidth,btnheight);
                           b1.setPrefSize(btnwidth,btnheight);
                           b0.setPrefSize(btnwidth,btnheight);
                           b8.setPrefSize(btnwidth,btnheight);
                           b9.setPrefSize(btnwidth,btnheight);
                           log.setPrefSize(btnwidth,btnheight);
                           div.setPrefSize(btnwidth,btnheight);
                           mul.setPrefSize(btnwidth,btnheight);
                           openp.setPrefSize(btnwidth,btnheight);
                           closep.setPrefSize(btnwidth,btnheight);
                           mince.setPrefSize(btnwidth,btnheight);
                           root.setPrefSize(btnwidth,btnheight);
                           equl.setPrefSize(btnwidth*2+5,btnheight);
                           pluse.setPrefSize(btnwidth,btnheight);
                           mod.setPrefSize(btnwidth,btnheight);
                           squer.setPrefSize(btnwidth,btnheight);
                           dot.setPrefSize(btnwidth,btnheight);
                           text.relocate(0,0);
                           b7.relocate(5,2*btnheight+10);
                           b4.relocate(5,3*btnheight+15);
                           b1.relocate(5,4*btnheight+20);
                           b0.relocate(5,5*btnheight+25);
                           b8.relocate(10+btnwidth,2*btnheight+10);
                           b5.relocate(10+btnwidth,3*btnheight+15);
                           b2.relocate(10+btnwidth,4*btnheight+20);
                           dot.relocate(10+btnwidth,5*btnheight+25);
                           b9.relocate(15+btnwidth*2,2*btnheight+10);
                           b6.relocate(15+btnwidth*2,3*btnheight+15);
                           b3.relocate(15+btnwidth*2,4*btnheight+20);
                           mod.relocate(15+btnwidth*2,5*btnheight+25);
                           div.relocate(20+btnwidth*3,2*btnheight+10);
                           mince.relocate(20+btnwidth*3,3*btnheight+15);
                           mul.relocate(20+btnwidth*3,4*btnheight+20);
                           pluse.relocate(20+btnwidth*3,5*btnheight+25);
                           c.relocate(25+4*btnwidth,2*btnheight+10);
                           openp.relocate(25+4*btnwidth,3*btnheight+15);
                           squer.relocate(25+4*btnwidth,4*btnheight+20);
                           equl.relocate(25+4*btnwidth,5*btnheight+25);
                           log.relocate(30+5*btnwidth,2*btnheight+10);
                           closep.relocate(30+5*btnwidth,3*btnheight+15);
                           root.relocate(30+5*btnwidth,4*btnheight+20);
                           }

                 );

               primaryStage.heightProperty().addListener(ov ->
                  {
                      heightlistner=primaryStage.getHeight();
                      widthlistner=primaryStage.getWidth();
                        text.setPrefSize(widthlistner,2*heightlistner/6);
                         btnwidth=(widthlistner-35)/6;
                         btnheight=(heightlistner-30)/6.5;
                        t1.setPrefSize(btnwidth*5+20,2*btnheight);
                           c.setPrefSize(btnwidth,btnheight);
                           del.setPrefSize(btnwidth,2*btnheight);
                           b7.setPrefSize(btnwidth,btnheight);
                           b6.setPrefSize(btnwidth,btnheight);
                           b5.setPrefSize(btnwidth,btnheight);
                           b4.setPrefSize(btnwidth,btnheight);
                           b3.setPrefSize(btnwidth,btnheight);
                           b2.setPrefSize(btnwidth,btnheight);
                           b1.setPrefSize(btnwidth,btnheight);
                           b0.setPrefSize(btnwidth,btnheight);
                           b8.setPrefSize(btnwidth,btnheight);
                           b9.setPrefSize(btnwidth,btnheight);
                           log.setPrefSize(btnwidth,btnheight);
                           div.setPrefSize(btnwidth,btnheight);
                           mul.setPrefSize(btnwidth,btnheight);
                           openp.setPrefSize(btnwidth,btnheight);
                           closep.setPrefSize(btnwidth,btnheight);
                           mince.setPrefSize(btnwidth,btnheight);
                           root.setPrefSize(btnwidth,btnheight);
                           equl.setPrefSize(btnwidth*2+5,btnheight);
                           pluse.setPrefSize(btnwidth,btnheight);
                           mod.setPrefSize(btnwidth,btnheight);
                           squer.setPrefSize(btnwidth,btnheight);
                           dot.setPrefSize(btnwidth,btnheight);
                           text.relocate(0,0);
                           b7.relocate(5,2*btnheight+10);
                           b4.relocate(5,3*btnheight+15);
                           b1.relocate(5,4*btnheight+20);
                           b0.relocate(5,5*btnheight+25);
                           b8.relocate(10+btnwidth,2*btnheight+10);
                           b5.relocate(10+btnwidth,3*btnheight+15);
                           b2.relocate(10+btnwidth,4*btnheight+20);
                           dot.relocate(10+btnwidth,5*btnheight+25);
                           b9.relocate(15+btnwidth*2,2*btnheight+10);
                           b6.relocate(15+btnwidth*2,3*btnheight+15);
                           b3.relocate(15+btnwidth*2,4*btnheight+20);
                           mod.relocate(15+btnwidth*2,5*btnheight+25);
                           div.relocate(20+btnwidth*3,2*btnheight+10);
                           mince.relocate(20+btnwidth*3,3*btnheight+15);
                           mul.relocate(20+btnwidth*3,4*btnheight+20);
                           pluse.relocate(20+btnwidth*3,5*btnheight+25);
                           c.relocate(25+4*btnwidth,2*btnheight+10);
                           openp.relocate(25+4*btnwidth,3*btnheight+15);
                           squer.relocate(25+4*btnwidth,4*btnheight+20);
                           equl.relocate(25+4*btnwidth,5*btnheight+25);
                           log.relocate(30+5*btnwidth,2*btnheight+10);
                           closep.relocate(30+5*btnwidth,3*btnheight+15);
                           root.relocate(30+5*btnwidth,4*btnheight+20);
                           }

                 );
               ///////////////////////////////////////////////////////////
            // pane.setStyle("-fx-background:#00FF00;");
             HBox.setMargin(t1,new Insets(5));
             HBox.setMargin(del,new Insets(5,0,0,0));
             /*
             t1.setStyle("-fx-border-color:#e96e00;-fx-border-width:5px;");
             equl.setStyle("-fx-color:#250808;-fx-background-radius: 0 0 0 0, 0 0 0 0, 0 0 0 0, 0 0 0 0;");
             b0.setStyle("-fx-font-size:2.5em;-fx-text-fill:#00ff00;-fx-background-color:rgba(97, 97, 97, 1);");
             b1.setStyle("-fx-font-size:2.5em;-fx-text-fill:#00ff00;-fx-background-color:rgba(97, 97, 97, 1);");
             b2.setStyle("-fx-font-size:2.5em;-fx-text-fill:#00ff00;-fx-background-color:rgba(97, 97, 97, 1);");
             b3.setStyle("-fx-font-size:2.5em;-fx-text-fill:#00ff00;-fx-background-color:rgba(97, 97, 97, 1);");
             b4.setStyle("-fx-font-size:2.5em;-fx-text-fill:#00ff00;-fx-background-color:rgba(97, 97, 97, 1);");
             b5.setStyle("-fx-font-size:2.5em;-fx-text-fill:#00ff00;-fx-background-color:rgba(97, 97, 97, 1);");
             b6.setStyle("-fx-font-size:2.5em;-fx-text-fill:#00ff00;-fx-background-color:rgba(97, 97, 97, 1);");
             //b6.setStyle("-fx-color:#626262;-fx-background-radius: 0 0 0 0, 0 0 0 0, 0 0 0 0, 0 0 0 0;");
             b7.setStyle("-fx-font-size:2.5em;-fx-text-fill:#00ff00;-fx-background-color:rgba(97, 97, 97, 1);");
             b8.setStyle("-fx-font-size:2.5em;-fx-text-fill:#00ff00;-fx-background-color:rgba(97, 97, 97, 1);");
             b9.setStyle("-fx-font-size:2.5em;-fx-text-fill:#00ff00;-fx-background-color:rgba(97, 97, 97, 1);");
             dot.setStyle("-fx-font-size:2.5em;-fx-text-fill:#00ff00;-fx-background-color:rgba(97, 97, 97, 1);");
             mod.setStyle("-fx-font-size:2.5em;-fx-text-fill:#00ff00;-fx-background-color:rgba(97, 97, 97, 1);");
             log.setStyle("-fx-font-size:2.5em;-fx-text-fill:#00ff00;-fx-background-color:rgba(10, 10, 10, 1);");
             c.setStyle("-fx-font-size:2.5em;-fx-text-fill:#00ff00;-fx-background-color:rgba(10, 10, 10, 1);");
             mince.setStyle("-fx-font-size:2.5em;-fx-text-fill:#00ff00;-fx-background-color:rgba(10, 10, 10, 1);");
             mul.setStyle("-fx-font-size:2.5em;-fx-text-fill:#00ff00;-fx-background-color:rgba(10, 10, 10, 1);");
             openp.setStyle("-fx-font-size:2.5em;-fx-text-fill:#00ff00;-fx-background-color:rgba(10, 10, 10, 1);");
             closep.setStyle("-fx-font-size:2.5em;-fx-text-fill:#00ff00;-fx-background-color:rgba(10, 10, 10, 1);");
             root.setStyle("-fx-font-size:2.5em;-fx-text-fill:#00ff00;-fx-background-color:rgba(10, 10, 10, 1);");
             squer.setStyle("-fx-font-size:2.5em;-fx-text-fill:#00ff00;-fx-background-color:rgba(10, 10, 10, 1);");
             div.setStyle("-fx-font-size:2.5em;-fx-text-fill:#00ff00;-fx-background-color:rgba(10, 10, 10, 1);");
             del.setStyle("-fx-font-size:2.5em;-fx-text-fill:#00ff00;-fx-background-color:rgba(10, 10, 10, 1);");
             pluse.setStyle("-fx-font-size:2.5em;-fx-text-fill:#00ff00;-fx-background-color:rgba(10, 10, 10, 1);");
             */
             scene.setOnKeyPressed(e->{
                 if(e.getCode()==KeyCode.CANCEL)primaryStage.close();
             });
             ////////////////////////////////////////////////////////////
            /*try{
             primaryStage.getIcons().add(new Image("capture.png"));
            }
            catch(Exception ex){}
             */
             //Image image = new Image("hihihi.jpg");
             primaryStage.getIcons().add(new Image("capture.png"));
             scene.getStylesheets().add("styles.css");
             primaryStage.setTitle("Android-Calculator-Using-JAVAFX"); // Set the stage title
            primaryStage.setScene(scene); // Place the scene in the stage
            primaryStage.show();
    }
    public static void main(String[] args)
    {
        Application.launch();
    }
}