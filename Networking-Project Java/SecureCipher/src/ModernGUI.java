import javax.swing.*;
import java.awt.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class ModernGUI extends JFrame {
    JTextArea InputText;
    JTextArea OutputText;
    JComboBox<String> AlgOptions;
    JButton Encrypt;
    JButton Decrypt;
    Thread EncryptThread;
    Thread DecryptThread;
    JComboBox<String> BSOptions;
    Thread MonitorBS;
    JTextField Pwd;
    JCheckBox Hash;
    JButton CopyOut;
    JButton PasteIn;
    Thread CopyThread;
    Thread PasteThread;
    JMenuItem about;
    JMenuItem help;
    JTextField InputFile;
    JTextField OutputDir;
    JButton Browse4F;
    JButton Browse4Dir;
    JButton EncryptF;
    JButton DecryptF;
    Thread OFThread;
    JFileChooser file;
    Thread ODThread;
    JTextArea FReport;
    JComboBox<String> FAlgOptions;
    JComboBox<String> FBSOptions;
    Thread MonitorFBS;
    Thread FEncryptThread;
    Thread FDecryptThread;
    JCheckBox FMode;
    JTextField FPwd;
    JTextArea HInText;
    JTextArea HOutText;
    JComboBox<String> HAlgOptions;
    JSpinner bcCost;
    JSpinner scCost;
    JSpinner scBSize;
    JSpinner scPar;
    JSpinner scLen;
    JButton DoHash;
    JButton HCopyOut;
    JButton HPasteIn;
    Thread HCThread;
    Thread HPThread;
    Thread DHThread;
    JButton HStop;
    JTextArea POut;
    JTextField CPChars;
    JComboBox<String> PChars;
    JSpinner RPassLen;
    JButton RPGen;
    JButton BPGen;
    JTextField OrigPass;
    JSpinner multKey;
    JSpinner RSeed;

    JButton GeneratePass;
    JSpinner BPassLen;
    Thread BPThread;
    Thread RPThread;
    Thread MonitorCPThread;
    JButton CopyPass;
    Thread CopyPassThread;
    JTextArea HelpText;
    JTextArea FAQText;
    JCheckBox wipe;

    public ModernGUI() {
        this.setSize(1000, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("USD Hybrid Cryptography - Java");

        ListenForButton L4B = new ListenForButton();

        JPanel MainPanel = new JPanel();

        JTabbedPane tabs = new JTabbedPane();
        tabs.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);

        JPanel TEPanel = new JPanel();
        TEPanel.setLayout(new GridBagLayout());

        GridBagConstraints GBC = new GridBagConstraints();
        GBC.gridx = 1;
        GBC.gridy = 1;
        GBC.gridwidth = 1;
        GBC.gridheight = 1;
        GBC.weightx = 0;
        GBC.weighty = 0;
        GBC.insets = new Insets(2, 5, 4, 4);
        GBC.anchor = GridBagConstraints.CENTER;
        GBC.fill = GridBagConstraints.BOTH;

        InputText = new JTextArea(10, 44);
        InputText.setText("Your input text goes here");
        InputText.setLineWrap(true);
        InputText.setWrapStyleWord(true);
        InputText.selectAll();
        InputText.setFocusable(true);
        GBC.gridx = 1;
        GBC.gridy = 1;
        GBC.gridwidth = 6;
        TEPanel.add(InputText, GBC);

        OutputText = new JTextArea(10, 44);
        OutputText.setText("The results will appear here.");
        OutputText.setLineWrap(true);
        OutputText.setWrapStyleWord(true);
        OutputText.setFocusable(true);
        OutputText.setEditable(false);
        GBC.gridx = 1;
        GBC.gridy = 2;
        GBC.gridwidth = 6;
        TEPanel.add(OutputText, GBC);

        AlgOptions = new JComboBox<String>();
        AlgOptions.addItem("AES");
        AlgOptions.addItem("CAST6");
        AlgOptions.addItem("RC6");
        AlgOptions.addItem("Rijndael");

        GBC.gridx = 3;
        GBC.gridy = 3;
        GBC.fill = GridBagConstraints.WEST;
        GBC.anchor = GridBagConstraints.WEST;
        GBC.gridwidth = 1;
        AlgOptions.addActionListener(L4B);
        TEPanel.add(AlgOptions, GBC);

        BSOptions = new JComboBox<String>();
        BSOptions.addItem("128 bit");
        BSOptions.addItem("192 bit");
        BSOptions.addItem("256 bit");
        GBC.gridx = 4;
        GBC.gridy = 3;
        GBC.fill = GridBagConstraints.WEST;
        GBC.anchor = GridBagConstraints.WEST;
        TEPanel.add(BSOptions, GBC);

        GeneratePass = new JButton("Generate Password");
        GBC.gridx = 2;
        GBC.gridy = 3;
        GBC.anchor = GridBagConstraints.WEST;
        GBC.gridwidth = 1;
        GeneratePass.addActionListener(L4B);
        TEPanel.add(GeneratePass, GBC);

        Pwd = new JTextField("Enter your password", 15);
        GBC.gridx = 1;
        GBC.gridy = 3;
        TEPanel.add(Pwd, GBC);

        Encrypt = new JButton("Encrypt");
        GBC.gridx = 5;
        GBC.gridy = 3;
        GBC.anchor = GridBagConstraints.WEST;
        GBC.gridwidth = 1;
        Encrypt.addActionListener(L4B);
        TEPanel.add(Encrypt, GBC);

        Decrypt = new JButton("Decrypt");
        GBC.gridx = 6;
        GBC.gridy = 3;
        GBC.anchor = GridBagConstraints.EAST;
        Decrypt.addActionListener(L4B);
        GBC.gridwidth = 1;
        TEPanel.add(Decrypt, GBC);

        PasteIn = new JButton("Paste input");
        GBC.gridx = 7;
        GBC.gridy = 1;
        PasteIn.addActionListener(L4B);
        TEPanel.add(PasteIn, GBC);

        CopyOut = new JButton("Copy Results");
        GBC.gridx = 7;
        GBC.gridy = 2;
        CopyOut.addActionListener(L4B);
        TEPanel.add(CopyOut, GBC);

        tabs.addTab("Text Encryptor", TEPanel);

        // Add other tabs here...

        MainPanel.setLayout(new BorderLayout());
        MainPanel.add(tabs, BorderLayout.CENTER);

        this.add(MainPanel);

        this.setVisible(true);
    }
    private class ListenForButton implements ActionListener
    {
        public void actionPerformed (ActionEvent e)
        {
            if (e.getSource() == Encrypt)
            {
                EncryptThread = new Thread()
                {
                    @Override
                    public void run()
                    {
                        long start = System.nanoTime();
                        OutputText.setText("Encrypting");
                        String CT = "";
                        try
                        {
                            if (Hash.isSelected())
                            {
                                CT = TextEncrypt.CBCEncrypt(InputText.getText(), Pwd.getText(), Integer.parseInt(BSOptions.getSelectedItem().toString().substring(0, BSOptions.getSelectedItem().toString().lastIndexOf("b") - 1)), AlgOptions.getSelectedIndex(), "Q");
                            }

                            else
                            {
                                CT = TextEncrypt.CBCEncrypt(InputText.getText(), Pwd.getText(), Integer.parseInt(BSOptions.getSelectedItem().toString().substring(0, BSOptions.getSelectedItem().toString().lastIndexOf("b") - 1)), AlgOptions.getSelectedIndex(), "S");
                            }
                        }

                        catch (Exception e)
                        {
                            CT = e.getMessage();
                        }
                        long elapsed = System.nanoTime() - start;

                        OutputText.setText(CT + "\n\nTotal time: " + elapsed/1e9 + " seconds.");

                    }//end of run body

                };//end of thread body
                EncryptThread.start();

            }//end of if

            else if (e.getSource() == Decrypt)
            {
                DecryptThread = new Thread()
                {
                    @Override
                    public void run()
                    {
                        long start = System.nanoTime();
                        OutputText.setText("Decrypting");
                        String CT = "";
                        try
                        {
                            if (Hash.isSelected())
                            {
                                CT = TextEncrypt.CBCDecrypt(InputText.getText(), Pwd.getText(), Integer.parseInt(BSOptions.getSelectedItem().toString().substring(0, BSOptions.getSelectedItem().toString().lastIndexOf("b") - 1)), AlgOptions.getSelectedIndex(), "Q");
                            }

                            else
                            {
                                CT = TextEncrypt.CBCDecrypt(InputText.getText(), Pwd.getText(), Integer.parseInt(BSOptions.getSelectedItem().toString().substring(0, BSOptions.getSelectedItem().toString().lastIndexOf("b") - 1)), AlgOptions.getSelectedIndex(), "S");
                            }
                        }

                        catch (Exception e)
                        {
                            CT = e.getMessage();
                        }
                        long elapsed = System.nanoTime() - start;

                        OutputText.setText(CT + "\n\nTotal time: " + elapsed/1e9 + " seconds.");

                    }//end of run body

                };//end of thread body
                DecryptThread.start();
            }//end of else if

            else if (e.getSource() == AlgOptions)
            {
                MonitorBS = new Thread()
                {
                    @Override
                    public void run()
                    {
                        if (AlgOptions.getSelectedItem().toString().equalsIgnoreCase("Threefish"))
                        {
                            BSOptions.removeAllItems();
                            BSOptions.addItem("256 bit");
                            BSOptions.addItem("512 bit");
                            BSOptions.addItem("1024 bit");
                        }

                        if ((!AlgOptions.getSelectedItem().toString().equalsIgnoreCase("Threefish")) && (AlgOptions.getItemCount() >= 4))
                        {
                            BSOptions.removeAllItems();
                            BSOptions.addItem("128 bit");
                            BSOptions.addItem("192 bit");
                            BSOptions.addItem("256 bit");
                        }

                        if ((AlgOptions.getSelectedItem().toString().equalsIgnoreCase("Shacal2")))
                        {
                            BSOptions.removeAllItems();
                            BSOptions.addItem("512 bit");
                        }
                    }

                };
                MonitorBS.start();
            }

            else if (e.getSource() == CopyOut)
            {
                CopyThread = new Thread()
                {
                    @Override
                    public void run()
                    {
                        StringSelection selection = null;

                        if (!OutputText.getText().equalsIgnoreCase("The results will appear here. If you're unable to use larger key sizes, refer to the FAQ in the help tab.\n"))
                        {
                            selection = new StringSelection(OutputText.getText().substring(0, OutputText.getText().length() - 34));
                        }

                        else
                        {
                            selection = new StringSelection(OutputText.getText().substring(0, OutputText.getText().length() - 1));
                        }

                        Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
                        cb.setContents(selection, selection);
                    }
                };

                CopyThread.start();
            }

            else if (e.getSource() == PasteIn)
            {
                PasteThread = new Thread()
                {
                    @Override
                    public void run()
                    {
                        Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
                        Transferable contents = cb.getContents(null);
                        try {
                            String input = (String) contents.getTransferData(DataFlavor.stringFlavor);
                            InputText.setText(input);
                        } catch (UnsupportedFlavorException e) {
                            InputText.setText(e.toString());
                        } catch (IOException e) {
                            InputText.setText(e.toString());
                        }
                    }
                };

                PasteThread.start();
            }

            else if (e.getSource() == Browse4F)
            {
                OFThread = new Thread(){
                    @Override
                    public void run(){
                        file = new JFileChooser();

                        int returnValue = file.showOpenDialog(null);

                        if (returnValue == JFileChooser.APPROVE_OPTION)
                        {
                            String fname = file.getSelectedFile().getAbsolutePath();

                            InputFile.setText(fname);
                        }

                    }
                };
                OFThread.start();
            }

            else if (e.getSource() == Browse4Dir)
            {
                ODThread = new Thread(){
                    @Override
                    public void run(){
                        file = new JFileChooser();

                        file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

                        int returnValue = file.showOpenDialog(null);

                        if (returnValue == JFileChooser.APPROVE_OPTION)
                        {
                            String dirname = file.getSelectedFile().getAbsolutePath();

                            OutputDir.setText(dirname);
                        }

                    }
                };
                ODThread.start();
            }

            else if (e.getSource() == FAlgOptions)
            {
                MonitorFBS = new Thread()
                {
                    @Override
                    public void run()
                    {
                        if (FAlgOptions.getSelectedItem().toString().equalsIgnoreCase("Threefish"))
                        {
                            FBSOptions.addItem("512 bit");
                            FBSOptions.addItem("1024 bit");
                        }

                        if ((!FAlgOptions.getSelectedItem().toString().equalsIgnoreCase("Threefish")) && (FAlgOptions.getItemCount() >= 4))
                        {
                            FBSOptions.removeAllItems();
                            FBSOptions.addItem("128 bit");
                            FBSOptions.addItem("192 bit");
                            FBSOptions.addItem("256 bit");
                        }

                        if ((FAlgOptions.getSelectedItem().toString().equalsIgnoreCase("Shacal2")))
                        {
                            FBSOptions.removeAllItems();
                            FBSOptions.addItem("512 bit");
                        }
                    }

                };
                MonitorFBS.start();
            }

            else if (e.getSource() == EncryptF)
            {
                FEncryptThread = new Thread()
                {
                    @Override
                    public void run()
                    {
                        FReport.setText("Encrypting...");
                        long start = System.nanoTime();
                        String OpRes = "";
                        if (wipe.isSelected())
                        {
                            if (FileEncrypt.checkFile(InputFile.getText() + ".enc"))
                            {
                                JOptionPane.showMessageDialog(ModernGUI.this, "An encrypted file with the same name already exists!\nRename or move it to avoid losing your data!", "Warning!", JOptionPane.WARNING_MESSAGE);
                            }

                            else
                            {
                                try
                                {
                                    try
                                    {
                                        if (FMode.isSelected())
                                        {
                                            OpRes = FileEncrypt.CBCEncrypt(FAlgOptions.getSelectedIndex(), Integer.parseInt(FBSOptions.getSelectedItem().toString().substring(0, FBSOptions.getSelectedItem().toString().lastIndexOf("b") - 1)), InputFile.getText(), FPwd.getText(), "Q");
                                        }

                                        else
                                        {
                                            OpRes= FileEncrypt.CBCEncrypt(FAlgOptions.getSelectedIndex(), Integer.parseInt(FBSOptions.getSelectedItem().toString().substring(0, FBSOptions.getSelectedItem().toString().lastIndexOf("b") - 1)), InputFile.getText(), FPwd.getText(), "S");
                                        }
                                    }

                                    catch (Exception e)
                                    {
                                        OpRes = e.getMessage();
                                    }

                                    FileEncrypt.wipeFile(InputFile.getText());
                                    long elapsed = System.nanoTime() - start;
                                    FReport.setText(OpRes + "\n\nTotal time: " + elapsed/1e9 + " seconds.");
                                    JOptionPane.showMessageDialog(ModernGUI.this, "Input file wiped successfully", "Success!", JOptionPane.INFORMATION_MESSAGE);
                                }
                                catch (FileNotFoundException e)
                                {
                                    JOptionPane.showMessageDialog(ModernGUI.this, "Could not find the input file", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                                catch (IOException e)
                                {
                                    JOptionPane.showMessageDialog(ModernGUI.this, "Could not find or access the input file", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }

                        }

                        else
                        {
                            try
                            {
                                if (FMode.isSelected())
                                {
                                    OpRes = FileEncrypt.CBCEncrypt(FAlgOptions.getSelectedIndex(), Integer.parseInt(FBSOptions.getSelectedItem().toString().substring(0, FBSOptions.getSelectedItem().toString().lastIndexOf("b") - 1)), InputFile.getText(), FPwd.getText(), "Q");
                                }

                                else
                                {
                                    OpRes= FileEncrypt.CBCEncrypt(FAlgOptions.getSelectedIndex(), Integer.parseInt(FBSOptions.getSelectedItem().toString().substring(0, FBSOptions.getSelectedItem().toString().lastIndexOf("b") - 1)), InputFile.getText(), FPwd.getText(), "S");
                                }
                            }

                            catch (Exception e)
                            {
                                OpRes = e.getMessage();
                            }
                        }


                    }//end of run body

                };//end of thread body
                FEncryptThread.start();
            }

            else if (e.getSource() == DecryptF)
            {
                FDecryptThread = new Thread()
                {
                    @Override
                    public void run()
                    {
                        FReport.setText("Decrypting...");
                        long start = System.nanoTime();
                        String OpRes = "";
                        if (wipe.isSelected())
                        {
                            if (FileEncrypt.checkFile(InputFile.getText() + ".enc"))
                            {
                                JOptionPane.showMessageDialog(ModernGUI.this, "An encrypted file with the same name already exists!\nRename or move it to avoid losing your data!", "Warning!", JOptionPane.WARNING_MESSAGE);
                            }

                            else
                            {
                                try
                                {
                                    try
                                    {
                                        if (FMode.isSelected())
                                        {
                                            OpRes = FileEncrypt.CBCDecrypt(FAlgOptions.getSelectedIndex(), Integer.parseInt(FBSOptions.getSelectedItem().toString().substring(0, FBSOptions.getSelectedItem().toString().lastIndexOf("b") - 1)), InputFile.getText(), FPwd.getText(), "Q");
                                        }

                                        else
                                        {
                                            OpRes= FileEncrypt.CBCDecrypt(FAlgOptions.getSelectedIndex(), Integer.parseInt(FBSOptions.getSelectedItem().toString().substring(0, FBSOptions.getSelectedItem().toString().lastIndexOf("b") - 1)), InputFile.getText(), FPwd.getText(), "S");
                                        }
                                    }

                                    catch (Exception e)
                                    {
                                        OpRes = e.getMessage();
                                    }

                                    FileEncrypt.wipeFile(InputFile.getText());
                                    long elapsed = System.nanoTime() - start;
                                    FReport.setText(OpRes + "\n\nTotal time: " + elapsed/1e9 + " seconds.");
                                    JOptionPane.showMessageDialog(ModernGUI.this, "Input file wiped successfully", "Success!", JOptionPane.INFORMATION_MESSAGE);
                                }
                                catch (FileNotFoundException e)
                                {
                                    JOptionPane.showMessageDialog(ModernGUI.this, "Could not find the input file", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                                catch (IOException e)
                                {
                                    JOptionPane.showMessageDialog(ModernGUI.this, "Could not find or access the input file", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }

                        }

                        else
                        {
                            try
                            {
                                if (FMode.isSelected())
                                {
                                    OpRes = FileEncrypt.CBCDecrypt(FAlgOptions.getSelectedIndex(), Integer.parseInt(FBSOptions.getSelectedItem().toString().substring(0, FBSOptions.getSelectedItem().toString().lastIndexOf("b") - 1)), InputFile.getText(), FPwd.getText(), "Q");
                                }

                                else
                                {
                                    OpRes= FileEncrypt.CBCDecrypt(FAlgOptions.getSelectedIndex(), Integer.parseInt(FBSOptions.getSelectedItem().toString().substring(0, FBSOptions.getSelectedItem().toString().lastIndexOf("b") - 1)), InputFile.getText(), FPwd.getText(), "S");
                                }
                            }

                            catch (Exception e)
                            {
                                OpRes = e.getMessage();
                            }
                        }

                    }//end of run body

                };//end of thread body
                FDecryptThread.start();
            }

            else if (e.getSource() == HAlgOptions)
            {
                if (HAlgOptions.getSelectedItem().toString().equalsIgnoreCase("bcrypt"))
                {
                    bcCost.setEnabled(true);
                }

                if (HAlgOptions.getSelectedItem().toString().equalsIgnoreCase("scrypt"))
                {
                    scCost.setEnabled(true);
                    scBSize.setEnabled(true);
                    scPar.setEnabled(true);
                    scLen.setEnabled(true);
                }

                if (!HAlgOptions.getSelectedItem().toString().equalsIgnoreCase("bcrypt"))
                {
                    bcCost.setEnabled(false);
                }

                if (!HAlgOptions.getSelectedItem().toString().equalsIgnoreCase("scrypt"))
                {
                    scCost.setEnabled(false);
                    scBSize.setEnabled(false);
                    scPar.setEnabled(false);
                    scLen.setEnabled(false);
                }
            }

            else if (e.getSource() == HPasteIn)
            {
                HPThread = new Thread()
                {
                    @Override
                    public void run()
                    {
                        Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
                        Transferable contents = cb.getContents(null);
                        try {
                            String input = (String) contents.getTransferData(DataFlavor.stringFlavor);
                            HInText.setText(input);
                        } catch (UnsupportedFlavorException e) {
                            HInText.setText(e.toString());
                        } catch (IOException e) {
                            HInText.setText(e.toString());
                        }
                    }
                };
                HPThread.start();
            }

            else if (e.getSource() == HCopyOut)
            {
                HCThread = new Thread()
                {
                    @Override
                    public void run()
                    {
                        StringSelection selection = new StringSelection(HOutText.getText().substring(0, HOutText.getText().indexOf("\n")));
                        Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
                        cb.setContents(selection, selection);
                    }
                };
                HCThread.start();
            }

            else if (e.getSource() == DoHash)
            {
                DHThread = new Thread()
                {
                    @Override
                    public void run()
                    {
                        HOutText.setText("Hashing...");
                        long start = System.nanoTime();
                        String HRes = "";
                        String p = HInText.getText();
                        try
                        {
                            switch (HAlgOptions.getSelectedIndex())
                            {
                                case 7:
                                    HRes = HashFactory.BCryptHash(p, (Integer) bcCost.getValue());
                                    break;
                                case 8:
                                    HRes = HashFactory.SCryptHash(p, (Integer) scCost.getValue(), (Integer) scBSize.getValue(), (Integer) scPar.getValue(), (Integer) scLen.getValue(), 1);
                                    break;
                                default:
                                    HRes = HashFactory.CommonHash(p, HAlgOptions.getSelectedItem().toString());
                                    break;

                            }

                        }
                        catch (Exception e)
                        {
                            HRes = e.getMessage();
                        }
                        long elapsed = System.nanoTime() - start;
                        HOutText.setText(HRes + "\n\nTotal time: " + elapsed/1e9 + " seconds.");;
                    }
                };
                DHThread.start();

            }

            else if (e.getSource() == HStop && DHThread.isAlive())
            {
                DHThread.interrupt();
                HOutText.setText("Operation interrupted by user");
            }

            else if (e.getSource() == BPGen)
            {
                BPThread = new Thread()
                {
                    @Override
                    public void run()
                    {
                        if ((Integer) BPassLen.getValue() < 8)
                        {
                            JOptionPane.showMessageDialog(ModernGUI.this, "Passwords that are below 8 characters in length are weak!", "Warning!", JOptionPane.WARNING_MESSAGE);
                        }

                        else
                        {
                            long start = System.nanoTime();
                            POut.setText("Boosting...");
                            String newPass ="";
                            try
                            {
                                newPass = PwdGen.BoostPass(OrigPass.getText(), (Integer) multKey.getValue(), (Integer) RSeed.getValue(), (Integer) BPassLen.getValue());
                            }
                            catch (Exception e)
                            {
                                newPass = "Unappropriate hashing algorithm";
                            }
                            long elapsed = System.nanoTime() - start;
                            POut.setText(newPass + "\n\nTotal time: " + elapsed/1e9 + " seconds.");
                        }

                    }
                };
                BPThread.start();
            }

            else if (e.getSource() == RPGen)
            {
                RPThread = new Thread()
                {
                    @Override
                    public void run()
                    {
                        if ((Integer) RPassLen.getValue() < 8)
                        {
                            JOptionPane.showMessageDialog(ModernGUI.this, "Passwords that are below 8 characters in length are weak!", "Warning!", JOptionPane.WARNING_MESSAGE);
                        }

                        else
                        {
                            long start = System.nanoTime();
                            String newPass ="";
                            try
                            {
                                if (PChars.getSelectedItem().toString().equalsIgnoreCase("custom"))
                                {
                                    newPass = PwdGen.SpecPassGen(CPChars.getText(), (Integer) RPassLen.getValue());
                                }

                                else
                                {
                                    newPass = PwdGen.RPassGen(PChars.getSelectedIndex() + 1, (Integer) RPassLen.getValue());
                                }

                            }
                            catch (Exception e)
                            {
                                newPass = "Unappropriate hashing algorithm";
                            }
                            long elapsed = System.nanoTime() - start;
                            POut.setText(newPass + "\n\nTotal time: " + elapsed/1e9 + " seconds.");
                        }

                    }
                };
                RPThread.start();
            }

            else if (e.getSource() == PChars)
            {
                MonitorCPThread = new Thread()
                {
                    @Override
                    public void run()
                    {
                        if (PChars.getSelectedItem().toString().equalsIgnoreCase("custom"))
                        {
                            CPChars.setEnabled(true);
                        }

                        else
                        {
                            CPChars.setEnabled(false);
                        }
                    }
                };
                MonitorCPThread.start();
            }

            else if (e.getSource() == CopyPass)
            {
                CopyPassThread = new Thread()
                {
                    @Override
                    public void run()
                    {
                        StringSelection selection = new StringSelection(POut.getText().substring(0, POut.getText().indexOf("\n")));
                        Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
                        cb.setContents(selection, selection);
                    }
                };

                CopyPassThread.start();
            }

            else if (e.getSource() == help)
            {
                JOptionPane.showMessageDialog(ModernGUI.this, "CryptoKnight is a general purpose cryptography app.\n\n Hover your mouse over untitled entry components for hints.", "Help", JOptionPane.QUESTION_MESSAGE);
            }

            else if (e.getSource() == about)
            {
                JOptionPane.showMessageDialog(ModernGUI.this, "License:\n\nCopyright (C) 2017 MCoury\nThis program is free software: you can redistribute it and/or modify\nit under the terms of the GNU General Public License as published by\nthe Free Software Foundation, either version 3 of the License, or\nany later version.\nThis program is distributed in the hope that it will be useful,\nbut WITHOUT ANY WARRANTY; without even the implied warranty of\nMERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the\nGNU General Public License for more details.\nYou should have received a copy of the GNU General Public License\nalong with this program.  If not, see http://www.gnu.org/licenses .\n\nWritten in Java\nBy MCoury", "About", JOptionPane.INFORMATION_MESSAGE);
            }

        }//end of actionperformed

    }//end of LFB class

    public static void main(String[] args) {
        // Create a new instance of the GUI on the Event-Dispatching thread
        SwingUtilities.invokeLater(ModernGUI::new);
    }
}
