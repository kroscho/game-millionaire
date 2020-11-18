import java.util.List;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nikita
 */
public class GameFrame extends javax.swing.JFrame {

    ArrayList<Question> questions = new ArrayList<>();
    private final Random  rnd = new Random();
    int Level =0;
    Question currentQuestion;
    int hints_count = 0;
    boolean rightOnMistakes = false;
    int Rewards;
    
    
    public GameFrame() {        
        initComponents();
        ReadFile();
        startGame();
    }
    
    //метод чтения вопросов из файла
    private void ReadFile()
    {
        try{
            FileInputStream fstream = new FileInputStream("D:\\Desktop\\ПМИ\\3 курс\\Компонентное программирование\\lab4\\Project\\Вопросы.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;

            while ((strLine = br.readLine()) != null) {
                String[] s = strLine.split("\t");
                questions.add(new Question(s));
            }
        } catch (IOException e) {
            System.out.println("Ошибка");
        }        
    }
    
    //метод отображения вопроса и ответов
    private void ShowQuestion(Question q)
    {     
        lblQuestionText.setText(q.Text);
        btnAnswer1.setText(q.Answers[0]);
        btnAnswer2.setText(q.Answers[1]);
        btnAnswer3.setText(q.Answers[2]);
        btnAnswer4.setText(q.Answers[3]);
    }
    
    //метод получения вопроса с заданным уровнем сложности
    private Question GetQuestion(int level)
    {
        List<Question> list;
        list = questions.stream().filter(q->q.Level==level).collect(Collectors.toList());
        return list.get(rnd.nextInt(list.size()));
    }
    
    private void NextStep()
    {        
        JButton[] btns = new JButton[]{btnAnswer1, btnAnswer2, btnAnswer3, btnAnswer4};
        
        for(JButton btn: btns)
            btn.setEnabled(true);
        
        if (Level<15)
        {
            Level++;
            currentQuestion = GetQuestion(Level);
            ShowQuestion(currentQuestion);        
            lstLevel.setSelectedIndex(lstLevel.getModel().getSize()-Level);   
        }
        else {
            JOptionPane.showMessageDialog(this, "Вы выиграли игру!\nВаш выигрыш составил 3 000 000 рублей!!!\nПоздравляем!!!");
            startGame();
        }
    }
    
    private void startGame()
    {
        //JOptionPane.showMessageDialog(null, new ChoosingANonCombustibleAmount());          
//        ChoosingANonCombustibleAmount form = new ChoosingANonCombustibleAmount();
//        form.setVisible(true);          
        
        Scanner in = new Scanner(System.in);
        System.out.println("Введите несгораемую сумму: ");
        Rewards = in.nextInt();   
        
        selectReward();
        
        Level = 0;
        hints_count = 0;
        EnabledAllHints(true);
        NextStep();
    }  
    
    //хотел, чтобы несгораемая сумма была выделена, не удалось
    private void selectReward()
    {
        for (int i=0; i<lstLevel.getModel().getSize(); i++)
        {
            String s = lstLevel.getModel().getElementAt(i).replaceAll(" ", "");
            if (Rewards == Integer.parseInt(s))
            {                
                lstLevel.setSelectedIndex(i); 
                break;
            }
        }   
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnHallHelp = new javax.swing.JButton();
        btnCallFriend = new javax.swing.JButton();
        btnGetMoney = new javax.swing.JButton();
        btnFiftyFifty = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblQuestionText = new javax.swing.JLabel();
        btnAnswer1 = new javax.swing.JButton();
        btnAnswer2 = new javax.swing.JButton();
        btnAnswer3 = new javax.swing.JButton();
        btnAnswer4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstLevel = new javax.swing.JList<>();
        btnTheRightToMakeMistakes = new javax.swing.JButton();
        btnChangeQuestion = new javax.swing.JButton();
        showRight = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnHallHelp.setText("Помощь зала");
        btnHallHelp.setName("btnHallHelp"); // NOI18N
        btnHallHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHallHelpActionPerformed(evt);
            }
        });

        btnCallFriend.setText("Звонок другу");
        btnCallFriend.setName("btnCallFriend"); // NOI18N
        btnCallFriend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCallFriendActionPerformed(evt);
            }
        });

        btnGetMoney.setText("Забрать деньги");
        btnGetMoney.setName("btnGetMoney"); // NOI18N
        btnGetMoney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetMoneyActionPerformed(evt);
            }
        });

        btnFiftyFifty.setText("50/50");
        btnFiftyFifty.setName("btnFiftyFifty"); // NOI18N
        btnFiftyFifty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiftyFiftyActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/newpackage/picture.jpg"))); // NOI18N
        jLabel1.setToolTipText("");

        lblQuestionText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblQuestionText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQuestionText.setText("lblQuestionText");
        lblQuestionText.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblQuestionText.setName("lblQuestionText"); // NOI18N

        btnAnswer1.setText("btnAnswer1");
        btnAnswer1.setActionCommand("1");
        btnAnswer1.setName("btnAnswer1"); // NOI18N
        btnAnswer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswer1ActionPerformed(evt);
            }
        });

        btnAnswer2.setText("btnAnswer2");
        btnAnswer2.setToolTipText("");
        btnAnswer2.setActionCommand("2");
        btnAnswer2.setName("btnAnswer2"); // NOI18N
        btnAnswer2.setOpaque(false);
        btnAnswer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswer2ActionPerformed(evt);
            }
        });

        btnAnswer3.setText("btnAnswer3");
        btnAnswer3.setToolTipText("");
        btnAnswer3.setActionCommand("3");
        btnAnswer3.setName("btnAnswer3"); // NOI18N
        btnAnswer3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswer3ActionPerformed(evt);
            }
        });

        btnAnswer4.setText("btnAnswer4");
        btnAnswer4.setToolTipText("");
        btnAnswer4.setActionCommand("4");
        btnAnswer4.setName("btnAnswer4"); // NOI18N
        btnAnswer4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswer4ActionPerformed(evt);
            }
        });

        lstLevel.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "3 000 000", "1 500 000", "   800 000", "   400 000", "   200 000", "   100 000", "     50 000", "     25 000", "     15 000", "     10 000", "       5 000", "       3 000", "       2 000", "       1 000", "          500" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstLevel.setName("lstLevel"); // NOI18N
        lstLevel.setRequestFocusEnabled(false);
        lstLevel.setSelectionBackground(new java.awt.Color(0, 0, 255));
        jScrollPane2.setViewportView(lstLevel);
        lstLevel.getAccessibleContext().setAccessibleName("lstLevel");

        btnTheRightToMakeMistakes.setText("Право на ошибку");
        btnTheRightToMakeMistakes.setName("btnTheRightToMakeMistakes"); // NOI18N
        btnTheRightToMakeMistakes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTheRightToMakeMistakesActionPerformed(evt);
            }
        });

        btnChangeQuestion.setText("Замена вопроса");
        btnChangeQuestion.setName("btnChangeQuestion"); // NOI18N
        btnChangeQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeQuestionActionPerformed(evt);
            }
        });

        showRight.setText("показать верный ответ");
        showRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showRightActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGetMoney, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFiftyFifty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTheRightToMakeMistakes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCallFriend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHallHelp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChangeQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblQuestionText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
            .addGroup(layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAnswer1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnswer3, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAnswer4, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnswer2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(showRight)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnFiftyFifty, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnHallHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCallFriend, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnTheRightToMakeMistakes, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnChangeQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btnGetMoney)))
                .addGap(12, 12, 12)
                .addComponent(lblQuestionText, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAnswer1)
                            .addComponent(btnAnswer2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAnswer3)
                            .addComponent(btnAnswer4))
                        .addContainerGap(26, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(showRight)
                        .addGap(49, 49, 49))))
        );

        lblQuestionText.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //выбор 1го ответа
    private void btnAnswer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswer1ActionPerformed
        
        unswerToTheQuestion(evt); 
    }//GEN-LAST:event_btnAnswer1ActionPerformed

    //выбор 2го ответа
    private void btnAnswer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswer2ActionPerformed
        
        unswerToTheQuestion(evt);         
    }//GEN-LAST:event_btnAnswer2ActionPerformed

    //выбор 3го ответа
    private void btnAnswer3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswer3ActionPerformed
        
        unswerToTheQuestion(evt);  
    }//GEN-LAST:event_btnAnswer3ActionPerformed

    //выбор 4го ответа
    private void btnAnswer4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswer4ActionPerformed
            
        unswerToTheQuestion(evt);
    }//GEN-LAST:event_btnAnswer4ActionPerformed
    
    //метод, вызывающийся при ответе
    private void unswerToTheQuestion(java.awt.event.ActionEvent evt)
    {
        if (currentQuestion.RightAnswer.equals(evt.getActionCommand()))
        {
            rightOnMistakes = false;
            NextStep();          
        }
        //если выбрана подсказка "Право на ошибку" 
        else if (rightOnMistakes)
        {
            JOptionPane.showMessageDialog(this, "Вы ответили неверно, но у вас есть еще одна попытка!");
            rightOnMistakes = false;
        }
        else if (Level > getLevelANonCombustibleAmount())
        {
            JOptionPane.showMessageDialog(this, "Ответ неверный, но вы получаете несгораемую сумму " + lstLevel.getModel().getElementAt(15-getLevelANonCombustibleAmount()) + " рублей!!!");
            startGame();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Ответ неверный, вы проиграли игру.");
            startGame();
        }
    }
    
    //подсказка "50/50"
    private void btnFiftyFiftyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiftyFiftyActionPerformed
        
        if (hints_count<4)
        {
        JButton[] btns = new JButton[]{btnAnswer1, btnAnswer2, btnAnswer3, btnAnswer4};
        
        int count = 0;
        while (count<2)
        {
            int n = rnd.nextInt(4);
            String ac = btns[n].getActionCommand();
            
            if (!ac.equals(currentQuestion.RightAnswer)
                    && btns[n].isEnabled())
            {
                btns[n].setEnabled(false);
                count++;
            }
        }
        hints_count++;
        EnabledAllHints(false);
        btnFiftyFifty.setEnabled(false);
        }        
    }//GEN-LAST:event_btnFiftyFiftyActionPerformed
    
    //подсказка "Звонок другу"
    private void btnCallFriendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCallFriendActionPerformed
        
        JButton[] btns = new JButton[]{btnAnswer1, btnAnswer2, btnAnswer3, btnAnswer4};
        
        for (int i=0; i<4; i++)
        {
            String ac = btns[i].getActionCommand();
            
            if (ac.equals(currentQuestion.RightAnswer))
            {
                JOptionPane.showMessageDialog(this, "Я думаю правильный ответ " + Integer.toString(i+1), "Друг:", 1);
                break;
            }
        }
        hints_count++;
        EnabledAllHints(false);
        btnCallFriend.setEnabled(false);
    }//GEN-LAST:event_btnCallFriendActionPerformed
    
    //подсказка "Право на ошибку"
    private void btnTheRightToMakeMistakesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTheRightToMakeMistakesActionPerformed
        
        rightOnMistakes = true;
        hints_count++;
        EnabledAllHints(false);
        btnTheRightToMakeMistakes.setEnabled(false);
    }//GEN-LAST:event_btnTheRightToMakeMistakesActionPerformed

    //подсказка "Замена вопроса"    
    private void btnChangeQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeQuestionActionPerformed
        
        currentQuestion = GetQuestion(Level);
        ShowQuestion(currentQuestion);        
        lstLevel.setSelectedIndex(lstLevel.getModel().getSize()-Level);
        hints_count++;
        EnabledAllHints(false);
        btnChangeQuestion.setEnabled(false);
    }//GEN-LAST:event_btnChangeQuestionActionPerformed

    //подсказка "Помощь зала"
    private void btnHallHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHallHelpActionPerformed
        
        //массив под процент голосов на ответы
        double[] ans = new double[]{0.,0.,0.,0.};
        int right = 0;
        double sum = 0;
        JButton[] btns = new JButton[]{btnAnswer1, btnAnswer2, btnAnswer3, btnAnswer4};
        
        for (int i=0; i<4; i++)
        {
            String ac = btns[i].getActionCommand();
            
            //на правильный ответ ставим процент голосов от 50 до 100
            if (ac.equals(currentQuestion.RightAnswer))
            {
                ans[i] = 50.0 + (double)(Math.random()*50.0);
                sum += ans[i];
                right = i;
                break;
            }
        }
        //на все остальные ответы распределяем оставшиеся проценты голосов
        for (int i=0; i<4; i++)
        {
            //если ответ последний и он неверный
            if (i!=right && i==3)
            {
                ans[i] = 100-sum;                
            }
            //если ответ последний и он верный
            else if (i==right && i==3)
            {
                ans[i-1] = 100-sum;
            }
            //если ответ неверный и не предпоследний
            else if (i!=right && i!=2)
            {
                ans[i] = 0.0 + (double)(Math.random()*(100-sum));
                sum+=ans[i];
            }
        } 
        
        JOptionPane.showMessageDialog(this, "1: " + String.format("%.2f", ans[0]) + "\n2: " + String.format("%.2f", ans[1]) + "\n3: " + String.format("%.2f", ans[2]) + "\n4: " + String.format("%.2f", ans[3]), "Зал:", 1);
        hints_count++;
        EnabledAllHints(false);
        btnHallHelp.setEnabled(false);
    }//GEN-LAST:event_btnHallHelpActionPerformed

    //просто так, чтоб показывало какой ответ правильный
    private void showRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showRightActionPerformed
        
        JButton[] btns = new JButton[]{btnAnswer1, btnAnswer2, btnAnswer3, btnAnswer4};
        
        for (int i=0; i<4; i++)
        {
            String ac = btns[i].getActionCommand();
            
            if (ac.equals(currentQuestion.RightAnswer))
            {
                JOptionPane.showMessageDialog(this, "Правильный ответ " + Integer.toString(i+1));
                break;
            }
        }
    }//GEN-LAST:event_showRightActionPerformed

    //забрать деньги
    private void btnGetMoneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetMoneyActionPerformed
        // TODO add your handling code here:
        int lev = getLevelANonCombustibleAmount();
        
        if (Level > lev)
        {
            JOptionPane.showMessageDialog(this, "Поздравляем, ваш выигрыш составил " + lstLevel.getModel().getElementAt(15-lev) + " рублей!!!");
            startGame();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "К сожалению, вы не можете забрать деньги.");
        }
    }//GEN-LAST:event_btnGetMoneyActionPerformed

    //получить уровень несгораемой суммы
    private int getLevelANonCombustibleAmount()
    {
        int lev=0;
        for (int i=0; i<lstLevel.getModel().getSize(); i++)
        {
            String s = lstLevel.getModel().getElementAt(i).replaceAll(" ", "");
            if (Rewards == Integer.parseInt(s))
            {                
                //lstLevel.setSelectedIndex(i); 
                lev=15-i;
                break;
            }
        }  
        return lev;
    }
    
    //блокировка/разблокировка кнопок подсказок
    private void EnabledAllHints(boolean f)
    {
        //если использованы уже 4 подсказки, то блокируем
        if (hints_count == 4)
        {
            btnFiftyFifty.setEnabled(f);
            btnHallHelp.setEnabled(f);
            btnCallFriend.setEnabled(f);
            btnTheRightToMakeMistakes.setEnabled(f);
            btnChangeQuestion.setEnabled(f);
        }
        //при новой игре разблокировка кнопок
        else if (f)
        {
            btnFiftyFifty.setEnabled(f);
            btnHallHelp.setEnabled(f);
            btnCallFriend.setEnabled(f);
            btnTheRightToMakeMistakes.setEnabled(f);
            btnChangeQuestion.setEnabled(f);
        }
    }
    
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
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameFrame().setVisible(true);
                //new ChoosingANonCombustibleAmount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnswer1;
    private javax.swing.JButton btnAnswer2;
    private javax.swing.JButton btnAnswer3;
    private javax.swing.JButton btnAnswer4;
    private javax.swing.JButton btnCallFriend;
    private javax.swing.JButton btnChangeQuestion;
    private javax.swing.JButton btnFiftyFifty;
    private javax.swing.JButton btnGetMoney;
    private javax.swing.JButton btnHallHelp;
    private javax.swing.JButton btnTheRightToMakeMistakes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblQuestionText;
    private javax.swing.JList<String> lstLevel;
    private javax.swing.JButton showRight;
    // End of variables declaration//GEN-END:variables
}
