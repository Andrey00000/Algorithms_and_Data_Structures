package pr12;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


// Абстрактный класс Shape
abstract class Shape {
    protected Color color;
    protected int x, y;

    public Shape(Color color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    // Абстрактные методы
    public abstract void draw(Graphics g);
}

    // Класс Circle (круг)
    class Circle extends Shape {
        private int radius;

        public Circle(Color color, int x, int y, int radius) {
            super(color, x, y);
            this.radius = radius;
        }

        @Override
        public void draw(Graphics g) {
            g.setColor(color);
            g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
        }
    }

    // Класс Rectangle (прямоугольник)
    class Rectangle extends Shape {
        private int width, height;

        public Rectangle(Color color, int x, int y, int width, int height) {
            super(color, x, y);
            this.width = width;
            this.height = height;
        }

        @Override
        public void draw(Graphics g) {
            g.setColor(color);
            g.fillRect(x, y, width, height);
        }
    }

    // Класс Triangle (треугольник)
    class Triangle extends Shape {
        private int base, height;

        public Triangle(Color color, int x, int y, int base, int height) {
            super(color, x, y);
            this.base = base;
            this.height = height;
        }

        @Override
        public void draw(Graphics g) {
            g.setColor(color);
            int[] xPoints = {x, x - base / 2, x + base / 2};
            int[] yPoints = {y, y + height, y + height};
            g.fillPolygon(xPoints, yPoints, 3);
        }
    }

    // Панель для рисования фигур
    class DrawingPanel extends JPanel {
        private List<Shape> shapes;
        private Random random;

        public DrawingPanel() {
            shapes = new ArrayList<>();
            random = new Random();
            setBackground(Color.WHITE);
            generateRandomShapes();
        }

        public void generateRandomShapes() {
            shapes.clear();
            for (int i = 0; i < 20; i++) {
                Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
                int x = random.nextInt(700) + 50;
                int y = random.nextInt(500) + 50;

                int shapeType = random.nextInt(3);
                Shape shape;

                switch (shapeType) {
                    case 0: // Circle
                        int radius = random.nextInt(40) + 20;
                        shape = new Circle(color, x, y, radius);
                        break;
                    case 1: // Rectangle
                        int width = random.nextInt(80) + 30;
                        int height = random.nextInt(80) + 30;
                        shape = new Rectangle(color, x, y, width, height);
                        break;
                    case 2: // Triangle
                        int base = random.nextInt(60) + 30;
                        int triangleHeight = random.nextInt(60) + 30;
                        shape = new Triangle(color, x, y, base, triangleHeight);
                        break;
                    default:
                        shape = new Circle(color, x, y, 30);
                }

                shapes.add(shape);
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Shape shape : shapes) {
                shape.draw(g);
            }
        }
    }

    // Главный класс приложения
    public class RandomShapesWindow extends JFrame {

        public RandomShapesWindow() {
            setTitle("20 Random Shapes");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(800, 600);
            setLocationRelativeTo(null);

            DrawingPanel drawingPanel = new DrawingPanel();

            JButton exitButton = new JButton("Выход");
            JButton restartButton = new JButton("Перезапуск");
            JPanel buttonPanel = new JPanel();
            buttonPanel.add(exitButton);
            buttonPanel.add(restartButton);

            exitButton.addActionListener(e -> System.exit(0));
            restartButton.addActionListener(e -> {
                drawingPanel.generateRandomShapes();
                drawingPanel.repaint();
            });

            add(drawingPanel);
            add(buttonPanel);

            setLayout(new BorderLayout());
            add(drawingPanel, BorderLayout.CENTER);
            add(buttonPanel, BorderLayout.SOUTH);
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                RandomShapesWindow window = new RandomShapesWindow();
                window.setVisible(true);
            });
        }
    }
