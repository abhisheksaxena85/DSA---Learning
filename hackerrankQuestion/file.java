import javax.swing.JButton;
import javax.swing.JFrame;
class HackerRankQuestion {
    public static void main(String[] args) { 
        // Scanner scan = new Scanner(System.in);
        // int i = scan.nextInt();
        // double d = scan.nextDouble();
        // scan.nextLine(); 

        // String value = scan.nextLine();

        // System.out.println("String: " + value);
        // System.out.println("Double: " + d);
        // System.out.println("Int: " + i);

        JFrame frame = new JFrame("Button Example");
        frame.setSize(300, 200);
        frame.setTitle("Hello World");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);  // Using null layout for absolute positioning

        // Create a JButton
        JButton button = new JButton("Click Me");
        button.setBounds(100, 80, 100, 30); // Set position and size (x, y, width, height)

        // Add button to frame
        frame.add(button);

        button.addActionListener(
            (actionEvent) -> {
                System.out.println(actionEvent.getID());
            }
        );

        // Make the frame visible
        frame.setVisible(true);
    }
}