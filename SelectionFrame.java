

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javafx.scene.control.RadioButton;
import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import static javax.swing.JColorChooser.showDialog;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;


public class SelectionFrame extends JFrame{
    private Color color;
    private JPanel shapeDrawing, ShapeData;
    private int x1 , x2, y2, y1, px, py, ph, pw, dofill;
    private int setType;
    private double rad, area, permiter;
    private JComboBox shapeChoiceBox;
    private JCheckBox filled;
    private JButton PickColor;
    private String fontType;
    private int fontStyle = 0;
    private void UtilizeColorPicker() {
        
        // Opens up the color window for user and repaint
        // oval with corresponding panel
        Color newColor = showDialog(this, "Choose a color", color);
        if (newColor == null){
            color = Color.LIGHT_GRAY;
        }
        else{
        color = newColor;
        }
        repaint();
    }
    
    // a method to handle the event of combo box being selected
    private void eventForComboBox(){
        shapeChoiceBox.addItemListener(
                    new ItemListener() //using default constructor
                    {
                        public void itemStateChanged(ItemEvent e) {
                            
                            // Depending on the selection sets the setype variable
                            // to int between 1-3 to determine shape being drawn
                            if(shapeChoiceBox.getSelectedIndex() == 0){
                                //circle
                                setType = 1;
                                
                            }
                            
                            
                            else if(shapeChoiceBox.getSelectedIndex() == 1){
                                //circle
                                setType = 2;
                            }
                            else if(shapeChoiceBox.getSelectedIndex() == 2){
                                //rectangle
                                setType = 3;
                            }
                            
                                
              
                        
                     }
                });
    }
    
    // A method that checks for filled checkbox and redraws shape
    // as filled if checked
    private void eventForJCheckBox(){
        
        filled.addItemListener(
                new ItemListener()
        {
            public void itemStateChanged(ItemEvent e){
                 if(filled.isSelected()){
                     
                     //Variable that is used to determine whether or not to fill
                     dofill =1;
                     repaint();
                 }
                 else{
                     dofill = 0;
                     repaint();
                 }
            }
                });
    }
    
    // a method that sets up event that calls on the color picker method
   
    private void eventForPickColor(){
        PickColor.addActionListener(
       new ActionListener() 
          {
              public void actionPerformed(ActionEvent e) {
              
                  
              
                  UtilizeColorPicker();
             
              }
            }); 
        
    }
    
    // The contructer method for creating the frame in main method
    public SelectionFrame(){
        
        
        super("Drawing Shapes and Displaying all info");
        
        // Creation of the area for results and interactive buttons
   
        JPanel ShapeDataAndButtons = new JPanel(new BorderLayout());
        JTextArea results = new JTextArea();
        results.setEditable(false);
        results.setFont(new Font("Serif", Font.PLAIN, 20));
        
        ShapeDataAndButtons.add(results, BorderLayout.CENTER);
        JPanel lowerButtons = new JPanel(new FlowLayout());
        String[] shapesChoice = new String[]{"CIRCLE", "RECTANGLE", "SQUARE"};
        shapeChoiceBox = new JComboBox<String>(shapesChoice);
        PickColor = new JButton("Pick Color");
        filled = new JCheckBox("Filled");
        lowerButtons.add(shapeChoiceBox);
        lowerButtons.add(PickColor);
        lowerButtons.add(filled);
        lowerButtons.setBackground(Color.LIGHT_GRAY);
        ShapeDataAndButtons.add(lowerButtons, BorderLayout.SOUTH);
        
        
        // A set of menu and menu items
        // with ther corresponding Mnemonic keys
        JMenu fileMenu = new JMenu("Draw");
        fileMenu.setMnemonic('d');
        JMenuBar MenuBar = new JMenuBar();
        JMenu shapes = new JMenu("Shapes");
        shapes.setMnemonic('s');
        JMenuItem Rec = new JMenuItem("Rectangle");
        Rec.setMnemonic('r');
        JMenuItem Cir = new JMenuItem("Circle");
        Cir.setMnemonic('c');
        JMenuItem Squ = new JMenuItem("Square");
        Squ.setMnemonic('q');
        shapes.add(Cir);
        shapes.add(Rec);
        shapes.add(Squ);
        fileMenu.add(shapes);
        MenuBar.add(fileMenu);
        JMenu text = new JMenu("Text");
        text.setMnemonic('t');
        JMenu menfontColor = new JMenu("Color");
        menfontColor.setMnemonic('l');
        
        
        // radio buton menu items for font color of text area for calculations 
        JRadioButtonMenuItem black = new JRadioButtonMenuItem(new AbstractAction("Black"){
            public void actionPerformed(ActionEvent e) {
                results.setForeground(Color.BLACK);
                repaint();
            }
        });
        JRadioButtonMenuItem blue = new JRadioButtonMenuItem(new AbstractAction("Blue"){
            public void actionPerformed(ActionEvent e) {
                results.setForeground(Color.BLUE);
                repaint();
            }
        });
        JRadioButtonMenuItem red = new JRadioButtonMenuItem(new AbstractAction("Red"){
            public void actionPerformed(ActionEvent e) {
                results.setForeground(Color.RED);
                repaint();
            }
        });;
        JRadioButtonMenuItem green = new JRadioButtonMenuItem(new AbstractAction("Green"){
            public void actionPerformed(ActionEvent e) {
                results.setForeground(Color.GREEN);
                repaint();
            }
        });
        
        
        // Adding radio buttons to group so when selected 
        // they deselect the other one.
        ButtonGroup colorButtonGroup = new ButtonGroup();
        colorButtonGroup.add(black);
        colorButtonGroup.add(blue);
        colorButtonGroup.add(red);
        colorButtonGroup.add(green);
        
        menfontColor.add(black);
        menfontColor.add(blue);  
        menfontColor.add(red);    
        menfontColor.add(green);  
        
        text.add(menfontColor);
        ButtonGroup fontGroup = new ButtonGroup();
        
        
        
        
        // Radio menu items for selecting the font type of menu area
        // When clicked the font will automatically update
        JMenu fontMen = new JMenu("Font");
        fontMen.setMnemonic('n');
        JRadioButtonMenuItem serifMen = new JRadioButtonMenuItem(new AbstractAction("Serif"){
            public void actionPerformed(ActionEvent e) {
                fontType = "Serif";
                results.setFont(new Font("Serif", fontStyle, 20));
                repaint();
            }
        });
        JRadioButtonMenuItem monoMen = new JRadioButtonMenuItem(new AbstractAction("Monospaced"){
            public void actionPerformed(ActionEvent e) {
                fontType = "Monospaced";
                results.setFont(new Font("Monospaced", fontStyle, 20));
                repaint();
            }
        });
        JRadioButtonMenuItem sanSerifMen = new JRadioButtonMenuItem(new AbstractAction("Sans Serif"){
            public void actionPerformed(ActionEvent e) {
                fontType = "SansSerif";
                results.setFont(new Font("SansSerif", fontStyle, 20));
                repaint();
            
            }
        });
        
        // adds the font buttons to there own group
        fontGroup.add(serifMen);
        fontGroup.add(monoMen);
        fontGroup.add(sanSerifMen);
        
        fontMen.add(serifMen);
        fontMen.add(monoMen);
        fontMen.add(sanSerifMen);
        
        
        // Check box menu items for allowing to change font style
        JCheckBoxMenuItem boldMen = new JCheckBoxMenuItem("Bold");
        JCheckBoxMenuItem italicMen = new JCheckBoxMenuItem("Italic");
        
        
        // Event for handling the changes to the text area of program for 
        // when the checkbox is interacted with
        boldMen.addItemListener(
                new ItemListener()
        {
            public void itemStateChanged(ItemEvent e){
                 if(boldMen.isSelected() && italicMen.isSelected() == false){
                     fontStyle = Font.BOLD;
                     results.setFont(new Font(fontType, fontStyle, 20));
                     repaint();
                 }
                 else if(boldMen.isSelected() && italicMen.isSelected()){
                     fontStyle = Font.BOLD + Font.ITALIC;
                     results.setFont(new Font(fontType, fontStyle, 20));
                     repaint();
                 }
                 else if(boldMen.isSelected() == false && italicMen.isSelected()){
                     fontStyle = Font.ITALIC;
                     results.setFont(new Font(fontType, fontStyle, 20));
                     repaint();
                 }
                 else {
                     fontStyle = Font.PLAIN;
                     results.setFont(new Font(fontType, fontStyle, 20));
                     repaint();
                 }
            }
        });
        italicMen.addItemListener(
                new ItemListener()
        {
            public void itemStateChanged(ItemEvent e){
                 if(italicMen.isSelected() && boldMen.isSelected() == false){
                     fontStyle = Font.ITALIC;
                     results.setFont(new Font(fontType, fontStyle, 20));
                     repaint();
                 }
                 else if(boldMen.isSelected() && italicMen.isSelected()){
                     fontStyle = Font.BOLD + Font.ITALIC;
                     results.setFont(new Font(fontType, fontStyle, 20));
                     repaint();
                 }
                 else if(boldMen.isSelected() && italicMen.isSelected() == false){
                     fontStyle = Font.BOLD;
                     results.setFont(new Font(fontType, fontStyle, 20));
                     repaint();
                 }
                 else{
                     fontStyle = Font.PLAIN;
                     results.setFont(new Font(fontType, fontStyle, 20));
                     repaint();
                 }
            }
        });
        
        
        // add thes to font submenu and creates seperator between font type
        // and stlyes 
        text.add(fontMen);
        fontMen.add(serifMen);
        fontMen.add(monoMen);
        fontMen.add(sanSerifMen);
        fontMen.addSeparator();
        fontMen.add(boldMen);
        fontMen.add(italicMen);
        
        // radio buton menu items for background color of text area for calculations 
        JMenu menBackColor = new JMenu("Background");
        menBackColor.setMnemonic('b');
        JRadioButtonMenuItem white = new JRadioButtonMenuItem(new AbstractAction("White"){
            public void actionPerformed(ActionEvent e) {
                results.setBackground(Color.WHITE);
                repaint();
            }
        });
        JRadioButtonMenuItem cyan = new JRadioButtonMenuItem(new AbstractAction("Cyan"){
            public void actionPerformed(ActionEvent e) {
                results.setBackground(Color.CYAN);
                repaint();
            }
        });
        JRadioButtonMenuItem yellow = new JRadioButtonMenuItem(new AbstractAction("Yellow"){
            public void actionPerformed(ActionEvent e) {
                results.setBackground(Color.YELLOW);
                repaint();
            }
        });
        JRadioButtonMenuItem lightGray = new JRadioButtonMenuItem(new AbstractAction("Light_Gray"){
            public void actionPerformed(ActionEvent e) {
                results.setBackground(Color.LIGHT_GRAY);
                repaint();
            }
        });
        
        
        // Adds background to there on group and adds to background submenu
        ButtonGroup textAreaGroup = new ButtonGroup();
        
        textAreaGroup.add(white);
        textAreaGroup.add(cyan);
        textAreaGroup.add(yellow);
        textAreaGroup.add(lightGray);
        
        
        menBackColor.add(white);
        menBackColor.add(cyan);
        menBackColor.add(yellow);
        menBackColor.add(lightGray);
        
        text.add(menBackColor);
        MenuBar.add(text);
        
        setJMenuBar(MenuBar);
        
        
        
        // Adds in the needed events for interacting with the 3 lower "buttons
        eventForComboBox();
        eventForPickColor();
        eventForJCheckBox();
       
        
        
        // Sets the type of shape to be drawn based of the menu
        Cir.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
            {
                setType = 1;
                shapeChoiceBox.setSelectedIndex(0);
            }
            }
         );
         
         Rec.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
            {
                setType = 2;
                shapeChoiceBox.setSelectedIndex(1);
            }
            }
         );
         Squ.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
            {
                setType = 3;
                shapeChoiceBox.setSelectedIndex(2);
            }
            }
         );
        
        
         
         // A mouse event for drawing the shapes to screen
        addMouseListener(new MouseAdapter()
       {

         @Override
         public void mousePressed(MouseEvent event){
             x1 = event.getX();
             y1 = event.getY();
             repaint();
         }
         @Override
         public void mouseReleased(MouseEvent event){
             x2 = event.getX();
             y2 = event.getY();
             repaint();
         }
         
     });
        addMouseMotionListener(new MouseMotionAdapter()
          {
              public void mouseDragged(MouseEvent event)
              {
                 x2= event.getX();
                 y2= event.getY();
                 repaint();
              }
          });

        
        
        this.shapeDrawing= new JPanel(new BorderLayout()){
        @Override
        public void paint(Graphics g) {
                super.paint(g);
                
                
        // Calculates result of shape drawn and paints them to the screen.
         if (setType == 1){
              px = Math.min(x1,x2);
              py = Math.min(y1,y2);
              pw = Math.abs(x1-x2);
             // Done to prevent ovals from being made
              ph = pw;
             
              g.setColor(color);
              g.drawOval(px, py, pw, ph);
              if (dofill == 1)
                 g.fillOval(px, py, pw, ph);
             //g.fillOval(x1, y2, x2, y2);
             Circle cir = new Circle((pw/2));
             double rad = cir.getRadius();
             double area = cir.getArea();
             double perm = cir.getPerimeter();
             results.setText("");
             
             results.append("Radius is " + Double.toString(rad));
             results.append("\nArea is " + Double.toString(area));
             results.append("\nPermeter is " + Double.toString(perm));
             
         }
         else if (setType == 2){
              px = Math.min(x1,x2);
              py = Math.min(y2,y2);
              pw = Math.abs(x1-x2);
              ph = Math.abs(y1-y2);
             g.setColor(color);
             g.drawRect(px, py, pw, ph);
             if (dofill == 1)
                 g.fillRect(px, py, pw, ph);
             Rectangle rec = new Rectangle(ph, pw);
          
             double area = rec.getArea();
             double perm = rec.getPerimeter();
             results.setText("");
             
             
             results.append("\nArea is " + Double.toString(area));
             results.append("\nPermeter is " + Double.toString(perm));
        }
         else if (setType == 3){
              px = Math.min(x1,x2);
              py = Math.min(y2,y2);
              pw = Math.abs(x1-x2);
              // done to prevent a rectangle being made
              ph = pw;
             g.setColor(color);
             g.drawRect(px, py, pw, ph);
             if (dofill == 1)
                 g.fillRect(px, py, pw, ph);
             Square squ = new Square(ph);
          
             double area = squ.getArea();
             double perm = squ.getPerimeter();
             results.setText("");
             
             
             results.append("\nArea is " + Double.toString(area));
             results.append("\nPermeter is " + Double.toString(perm));
         }
    }
    
    
    
        };
        
        
        // Adds the two panels to frame
        add(shapeDrawing, BorderLayout.CENTER);
        add(ShapeDataAndButtons, BorderLayout.SOUTH);
    }


        
    
    
}
