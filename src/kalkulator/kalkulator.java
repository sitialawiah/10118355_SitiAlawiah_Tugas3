
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalkulator;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javax.swing.text.BadLocationException;

/**
 *
 * @author sitialawiah
 */
public class kalkulator extends javax.swing.JFrame {
    private boolean koma = false;

    /**
     * Creates new form kalkulator
     */
    public kalkulator() {
        initComponents();
        setLocationRelativeTo(null);
        initKeyListener();
    }
    
    private void initKeyListener(){
        KeyListener keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch(e.getKeyChar()){
                    case KeyEvent.VK_0 : {
                        btn0.doClick();
                        break; }
                    case KeyEvent.VK_1 : {
                        btn1.doClick();
                        break; }
                    case KeyEvent.VK_2 : {
                        btn2.doClick();
                        break; }
                    case KeyEvent.VK_3 : {
                        btn3.doClick();
                        break; }
                    case KeyEvent.VK_4 : {
                        btn4.doClick();
                        break; }
                    case KeyEvent.VK_5 : {
                        btn5.doClick();
                        break; }
                    case KeyEvent.VK_6 : {
                        btn6.doClick();
                        break; }
                    case KeyEvent.VK_7 : {
                        btn7.doClick();
                        break; }
                    case KeyEvent.VK_8 : {
                        btn8.doClick();
                        break; }
                    case KeyEvent.VK_9 : {
                        btn9.doClick();
                        break; }
                    case KeyEvent.VK_COMMA :
                    case KeyEvent.VK_PERIOD : {
                        btnkoma.doClick();
                        break; }
                    case KeyEvent.VK_ENTER :
                    case KeyEvent.VK_EQUALS :{
                        btnkurang.doClick();
                        break; }
                    case '*' : {
                        btnkali.doClick();
                        break; }
                    case KeyEvent.VK_SLASH : {
                        btnbagi.doClick();
                        break; }
                    case KeyEvent.VK_MINUS : {
                        btnkurang.doClick();
                        break; }
                    case '+' : {
                        btntambah.doClick();
                        break; }
                    case KeyEvent.VK_BACK_SPACE : {
                        btnhapus.doClick();
                        break; }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        };
       
        this.addKeyListener(keyListener);
        lblhasil.addKeyListener(keyListener);
    }
    
    private int operator(char c){
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }
    
    private float kalkulator(List<String> postFixList){
        Stack<Float> stack = new Stack<>();
        for (String word : postFixList) {
            if(word.length() == 1 && (word.charAt(0) == '+' || word.charAt(0) == '-' || word.charAt(0) == '*' || word.charAt(0) == '/')){
                float angka2 = stack.pop();
                float angka1 = stack.pop();
                switch (word.charAt(0)) {
                    case '+': {
                            float angka = angka1+angka2;
                            stack.push(angka);
                            break;
                        }
                    case '-': {
                            float angka = angka1-angka2;
                            stack.push(angka);
                            break;
                        }
                    case '*': {
                            float angka = angka1*angka2;
                            stack.push(angka);
                            break;
                        }
                    case '/': {
                            float angka = angka1/angka2;
                            stack.push(angka);
                            break;
                        }
                }
            }else{
                float angka = Float.parseFloat(word);
                stack.push(angka);
            }
        }
        return stack.peek();
    }
    
    private List<String> getInfixToPostfix(String s){
        Stack<Character> stack = new Stack<>();
        List<String> List = new ArrayList<>();
        boolean Angka = false;
        
        int i = 0;
        for(i = 0; i < s.length(); i++){
            char word = s.charAt(i);
            
            switch (word) {
                case '+':
                case '-':
                case '*':
                case '/':{
                    if(stack.isEmpty()){
                        stack.push(word);
                    }
                    else{
                        while(!stack.isEmpty() && operator(stack.peek()) >= operator(word)){
                            List.add(stack.pop().toString());
                        }
                        stack.push(word);
                    }   
                    
                    Angka = false;
                    break;
                }
                default:{
                    if(Angka){
                        String angkaa = List.get(List.size()-1);
                        angkaa += word;
                        List.set(List.size()-1, angkaa);
                    }
                    else {
                        List.add(word+"");
                    }
                    Angka = true;
                    break;
                }
            }
        }
        while(!stack.isEmpty()){
            List.add(stack.pop().toString());
        }
        return List;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblhasil = new javax.swing.JTextField();
        btnbagi = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btnkali = new javax.swing.JButton();
        btnkurang = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btntambah = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn0 = new javax.swing.JButton();
        btnsamadengan = new javax.swing.JButton();
        btnkoma = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kalkulator");

        lblhasil.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblhasil.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        lblhasil.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        btnbagi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnbagi.setText("/");
        btnbagi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbagiActionPerformed(evt);
            }
        });

        btnhapus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnhapus.setText("C");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        btn7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn7.setText("7");
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });

        btn8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn8.setText("8");
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });

        btn9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn9.setText("9");
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });

        btnkali.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnkali.setText("x");
        btnkali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkaliActionPerformed(evt);
            }
        });

        btnkurang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnkurang.setText("-");
        btnkurang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkurangActionPerformed(evt);
            }
        });

        btn6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn6.setText("6");
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });

        btn4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn4.setText("4");
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        btn5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn5.setText("5");
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });

        btn2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn2.setText("2");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        btn1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn1.setText("1");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btntambah.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btntambah.setText("+");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });

        btn3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn3.setText("3");
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        btn0.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn0.setText("0");
        btn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0ActionPerformed(evt);
            }
        });

        btnsamadengan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnsamadengan.setText("=");
        btnsamadengan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsamadenganActionPerformed(evt);
            }
        });

        btnkoma.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnkoma.setText(".");
        btnkoma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkomaActionPerformed(evt);
            }
        });

        btndelete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btndelete.setText("AC");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblhasil, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btn1, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                                        .addGap(68, 68, 68))
                                    .addComponent(btn0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnkoma, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btn4, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                                    .addComponent(btn7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btn5, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                                            .addComponent(btn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btn6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btndelete, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnkali, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnbagi, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnkurang, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btntambah, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnsamadengan, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblhasil, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnbagi, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnkali, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnkurang, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btntambah, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnkoma, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnsamadengan, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0ActionPerformed
        // TODO add your handling code here:
        lblhasil.setText(lblhasil.getText() + "0");
        this.requestFocus();
    }//GEN-LAST:event_btn0ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        // TODO add your handling code here:
        lblhasil.setText(lblhasil.getText() + "1");
        this.requestFocus();
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        // TODO add your handling code here:
        lblhasil.setText(lblhasil.getText() + "2");
        this.requestFocus();
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        // TODO add your handling code here:
        lblhasil.setText(lblhasil.getText() + "3");
        this.requestFocus();
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        // TODO add your handling code here:
        lblhasil.setText(lblhasil.getText() + "4");
        this.requestFocus();
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        // TODO add your handling code here:
        lblhasil.setText(lblhasil.getText() + "5");
        this.requestFocus();
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        // TODO add your handling code here:
        lblhasil.setText(lblhasil.getText() + "6");
        this.requestFocus();
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        // TODO add your handling code here:
        lblhasil.setText(lblhasil.getText() + "7");
        this.requestFocus();
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        // TODO add your handling code here:
        lblhasil.setText(lblhasil.getText() + "8");
        this.requestFocus();
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        // TODO add your handling code here:
        lblhasil.setText(lblhasil.getText() + "9");
        this.requestFocus();
    }//GEN-LAST:event_btn9ActionPerformed

    private void btnkomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkomaActionPerformed
        // TODO add your handling code here:
        if (!koma){
            String hasil = lblhasil.getText();
            if (!hasil.isEmpty()){
                char end = hasil.charAt(hasil.length()-1);
                switch (end){
                    case '+':
                    case '-':
                    case '*':
                    case '/':
                    case '.':
                    case 0:
                    break;
                    default : {
                        lblhasil.setText(lblhasil.getText() + ".");
                        koma = true;
                    }
                }
            }
        }
        this.requestFocus();
    }//GEN-LAST:event_btnkomaActionPerformed

    private void btnsamadenganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsamadenganActionPerformed
        // TODO add your handling code here:
        List<String> postfixed = getInfixToPostfix(lblhasil.getText());
        lblhasil.setText(kalkulator(postfixed) + "");
        koma = true;
        this.requestFocus();
    }//GEN-LAST:event_btnsamadenganActionPerformed

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        // TODO add your handling code here:
        String hasil = lblhasil.getText();
        if (!hasil.isEmpty()){
            char end = hasil.charAt(hasil.length()-1);
            switch (end){
                case '+':
                case '-':
                case '*':
                case '/':
                case '.':
                case 0:
                break;
                default : {
                    lblhasil.setText(lblhasil.getText() + "+");
                    koma = false;
                }
            }
        }
        this.requestFocus();
    }//GEN-LAST:event_btntambahActionPerformed

    private void btnkurangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkurangActionPerformed
        // TODO add your handling code here:
        String hasil = lblhasil.getText();
        if (!hasil.isEmpty()){
            char end = hasil.charAt(hasil.length()-1);
            switch (end){
                case '+':
                case '-':
                case '*':
                case '/':
                case '.':
                case 0:
                break;
                default : {
                    lblhasil.setText(lblhasil.getText() + "-");
                    koma = false;
                }
            }
        }
        this.requestFocus();
    }//GEN-LAST:event_btnkurangActionPerformed

    private void btnkaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkaliActionPerformed
        // TODO add your handling code here:
        String hasil = lblhasil.getText();
        if (!hasil.isEmpty()){
            char end = hasil.charAt(hasil.length()-1);
            switch (end){
                case '+':
                case '-':
                case '*':
                case '/':
                case '.':
                case 0:
                break;
                default : {
                    lblhasil.setText(lblhasil.getText() + "*");
                    koma = false;
                }
            }
        }
        
        this.requestFocus();
    }//GEN-LAST:event_btnkaliActionPerformed

    private void btnbagiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbagiActionPerformed
        // TODO add your handling code here:
        String hasil = lblhasil.getText();
        if (!hasil.isEmpty()){
            char end = hasil.charAt(hasil.length()-1);
            switch (end){
                case '+':
                case '-':
                case '*':
                case '/':
                case '.':
                case 0:
                break;
                default : {
                    lblhasil.setText(lblhasil.getText() + "/");
                    koma = false;
                }
            }
        }
        this.requestFocus();
    }//GEN-LAST:event_btnbagiActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
        String hasil = lblhasil.getText();
        if (!hasil.isEmpty()){
            try {
                char end = hasil.charAt(hasil.length()-1);
                if (end == '.'){
                    koma = false;
                }
              
                lblhasil.setText(lblhasil.getText(0, lblhasil.getText().length()-1));
            } catch (BadLocationException ex) {

            }
        }
        
        this.requestFocus();
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
        lblhasil.setText("");
        koma = false;
        this.requestFocus();
    }//GEN-LAST:event_btndeleteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(kalkulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(kalkulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(kalkulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(kalkulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new kalkulator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnbagi;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnkali;
    private javax.swing.JButton btnkoma;
    private javax.swing.JButton btnkurang;
    private javax.swing.JButton btnsamadengan;
    private javax.swing.JButton btntambah;
    private javax.swing.JTextField lblhasil;
    // End of variables declaration//GEN-END:variables
}