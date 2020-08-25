package com.zhangqianchun.Pojo;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class Image {

    private int weight = 100; //��֤��ͼƬ�ĳ��Ϳ�
    private int height = 40;
    private String text; //����������֤����ı�����
    private Random random = new Random(); //��ȡ���������
    //private String[] fontNames = {"����", "���Ŀ���", "����", "΢���ź�", "����_GB2312"};   //��������
    //��������
    private String[] fontNames = {"Georgia"};
    //��֤������
    private String codes = "23456789abcdefghjkmnopqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ";

    /* ��ȡ�������ɫ */
    private Color randomColor() {

        int r = this.random.nextInt(225); //����Ϊʲô��225����Ϊ��r��g��b��Ϊ255ʱ����Ϊ��ɫ��Ϊ�˺ñ��ϣ���Ҫ��ɫ��һ�㡣
        int g = this.random.nextInt(225);
        int b = this.random.nextInt(225);

        return new Color(r,g,b); //����һ�������ɫ
    }

    /* ��ȡ������� */
    private Font randomFont() {

        int index = random.nextInt(fontNames.length); //��ȡ���������
        String fontName = fontNames[index];
        int style = random.nextInt(4); //�����ȡ�������ʽ��0������ʽ��1�ǼӴ֣�2��б�壬3�ǼӴּ�б��
        int size = random.nextInt(10) + 24; //�����ȡ����Ĵ�С

        return new Font(fontName,style,size); //����һ�����������
    }

    /* ��ȡ����ַ� */
    private char randomChar() {

        int index = random.nextInt(codes.length());

        return codes.charAt(index);
    }

    /* �������ߣ���֤�������������ֹ���������ͼƬ */
    private void drawLine(BufferedImage image) {

        int num = random.nextInt(10); //��������ߵ�����
        Graphics2D graphics2D = (Graphics2D) image.getGraphics();

        for (int i = 0; i < num; i++) {

            int x1 = random.nextInt(weight);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(weight);
            int y2 = random.nextInt(height);

            graphics2D.setColor(randomColor());
            graphics2D.drawLine(x1,y1,x2,y2);
        }
    }

    /* ����ͼƬ�ķ��� */
    private BufferedImage createImage() {

        //����ͼƬ������
        BufferedImage image = new BufferedImage(weight,height,BufferedImage.TYPE_INT_RGB);

        //��ȡ����
        Graphics2D graphics2D = (Graphics2D) image.getGraphics();

        //���ñ���ɫ���
        graphics2D.setColor(new Color(225,225,random.nextInt(245)+10));
        graphics2D.fillRect(0,0,weight,height);

        //����һ��ͼƬ
        return image;
    }

    /* ��ȡ��֤��ͼƬ�ķ��� */
    public BufferedImage getImage() {

        BufferedImage image = createImage();
        Graphics2D graphics2D = (Graphics2D) image.getGraphics();

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 4; i++) { //���ĸ��ַ�����

            String s =randomChar()+" "; //��������ַ�����Ϊֻ�л��ַ����ķ�����û�л��ַ��ķ�����������Ҫ���ַ�����ַ����ٻ�
            stringBuilder.append(s);
            float x = i*1.0F*weight/4;//�����ַ���x����
            graphics2D.setFont(randomFont());
            graphics2D.setColor(randomColor());
            graphics2D.drawString(s,x,height-5);

        }

        this.text = stringBuilder.toString();
        drawLine(image);

        return image;
    }

    /* ��ȡ��֤���ı��ķ��� */
    public String getText() {
        return text;
    }

    public static void output(BufferedImage image, OutputStream outputStream) throws IOException {
        ImageIO.write(image,"JPEG",outputStream);
    }

}
