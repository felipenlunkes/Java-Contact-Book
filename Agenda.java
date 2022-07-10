  
  
    import java.awt.FlowLayout;   
    import java.awt.*;
    import java.*;
	import java.awt.event.ActionEvent;   
	import java.awt.event.ActionListener;   
	import java.sql.Connection;   
	import java.sql.DriverManager;   
	import java.sql.SQLException;   
	import java.sql.Statement;   
	import java.sql.*;
	   
	import javax.swing.JButton;   
	import javax.swing.JFrame;   
	import javax.swing.JLabel;   
	import javax.swing.JOptionPane;   
	import javax.swing.JTextField;   
	   
	   
	public class Trabalho extends JFrame implements ActionListener{   
	   
	    private Connection conn;  
	    JFrame cadastro = new JFrame("Cadastro");
	    
	    JFrame principal = new JFrame("Página Inicial");   
	    
	    private static final long serialVersionUID = 1L;   
	    JTextField jtProduto = new JTextField(40);   
	    JTextField jtPreco = new JTextField(40);
	    
	    /*
	     * 
	     */
	    
	    JButton jblimpar = new JButton("Limpar...");
	     JButton jbexcluir = new JButton("Excluir");
	     JButton jbconsultar = new JButton("Consultar...");
	    JLabel jlnome = new JLabel("Nome:");
	    JLabel jlemail = new JLabel("Email:");
	    JLabel jlendereco = new JLabel("Endereço:");
	    JLabel jlbairro = new JLabel("Bairro:");
	    JButton jbcadastrar = new JButton("Cadastrar...");
	    JButton jbfechar = new JButton("Fechar...");
	    JTextField jtnome = new JTextField(40);
	    JTextField jtemail = new JTextField(40);
	    JTextField jtendereco = new JTextField(40);
	    JTextField jtbairro = new JTextField(20);
	    
	    /*
	     *
	     */
	    
	  
	     JButton jlcadastrar = new  JButton("Cadastrar dados...    F2");
	     JButton jlexcluir = new    JButton("Excluir dados...        F3");
	    JButton jlalterar = new  JButton("Alterar dados...       F4");
	    JButton jlpesquisar = new  JButton   ("Pesquisar dados...   F5");
	   

	       
	  
	       
	    public Trabalho() {   
			
			
	        //setLayout(new FlowLayout(FlowLayout.RIGHT));   
	        principal.setLayout(null);
	        jlcadastrar.setBounds(18,18,200,30);
	        jlexcluir.setBounds(18,60,200,30);
	        jlalterar.setBounds(18,110,200,30);
	        jlpesquisar.setBounds(18,160,200,30);
	        principal.add(jlcadastrar);
	        principal.add(jlexcluir);
	        principal.add(jlalterar);
	        principal.add(jlpesquisar);  
	        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
	        principal.setLocationRelativeTo(null);   
	        principal.setVisible(true);   
	        principal.setSize(700,300);
	       
			cadastro.setVisible(false);
			cadastro.setSize(700,350);   
	        jlcadastrar.addActionListener(this);
	        jlexcluir.addActionListener(this);
	        jlalterar.addActionListener(this);
	        jlpesquisar.addActionListener(this);
	        jblimpar.addActionListener(this);
	        jbfechar.addActionListener(this);
	     
	    
	    }   
	    public static void main(String []args){   
	        new Trabalho();
    }   
       
           public int fechar(){
				cadastro.setVisible(false);
				principal.setVisible(true);
				return 0;
			}
			
	    public void actionPerformed(ActionEvent arg0) { 
			
			if (arg0.getSource() == jlexcluir){
				
				jbexcluir.addActionListener(this);
				cadastro.setVisible(true);
				cadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
				cadastro.setLayout(null);
				jlnome.setBounds(18,18,100,30);
				jtnome.setBounds(100,18,100,30);
				jlemail.setBounds(18,60,100,30);
				jtemail.setBounds(100,60,100,30);
				jlendereco.setBounds(18,120,100,30);
				jtendereco.setBounds(100,120,100,30);
				jblimpar.setBounds(100,220,200,30);
				jlbairro.setBounds(18,150,100,30);
				jbfechar.setBounds(100,280,200,30);
				jtbairro.setBounds(100,150,100,30);
				jbexcluir.setBounds(290,220,200,30);
				cadastro.add(jlnome);
				cadastro.add(jtnome);
				cadastro.add(jlemail);
				cadastro.add(jtemail);
				cadastro.add(jlendereco);
				cadastro.add(jtendereco);
				cadastro.add(jlbairro);
				cadastro.add(jtbairro);
				cadastro.add(jblimpar);
				cadastro.add(jbfechar);
				cadastro.add(jbexcluir);
				
				
			}
			if (arg0.getSource() == jlcadastrar){
				
				jbcadastrar.addActionListener(this);
				cadastro.setVisible(true);
				cadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
				cadastro.setLayout(null);
				jlnome.setBounds(18,18,100,30);
				jtnome.setBounds(100,18,100,30);
				jlemail.setBounds(18,60,100,30);
				jtemail.setBounds(100,60,100,30);
				jlendereco.setBounds(18,120,100,30);
				jtendereco.setBounds(100,120,100,30);
				jbcadastrar.setBounds(100,220,200,30);
				jlbairro.setBounds(18,150,100,30);
				jtbairro.setBounds(100,150,100,30);
				jblimpar.setBounds(290,220,200,30);
				cadastro.add(jlnome);
				cadastro.add(jtnome);
				cadastro.add(jlemail);
				cadastro.add(jtemail);
				cadastro.add(jlendereco);
				cadastro.add(jtendereco);
				cadastro.add(jlbairro);
				cadastro.add(jtbairro);
				cadastro.add(jbcadastrar);
				cadastro.add(jbfechar);
				cadastro.add(jblimpar);
				
			}
			
			if (arg0.getSource() == jbexcluir){
				
				try{
					
					 JOptionPane.showMessageDialog(null,"Excluir Cadastro...");  
 	            Class.forName("com.mysql.jdbc.Driver"); 	     
	            Connection c = DriverManager.getConnection("jdbc:mysql://192.168.50.100/java10102013", "root", "suporte");   
	            Statement stm = c.createStatement();  
	            
	            if (jtnome.getText() == null | jtemail.getText() == null | jtbairro.getText() == null | jtendereco.getText() == null){
				JOptionPane.showMessageDialog(null, "Algum campo não foi preenchido.");   	
			}
				
	            String nome = jtnome.getText();
	            String email = jtemail.getText();
	            String endereco = jtendereco.getText();
	            String bairro = jtbairro.getText(); 
	            
	            stm.executeUpdate("delete from cadastro where nome='"+nome+"'");   
	            JOptionPane.showMessageDialog(null, "Dados removidos com sucesso.");  
					
				}
				
				catch(SQLException ex){   
	            JOptionPane.showMessageDialog(null,"Ocorreu um erro no Banco de Dados utilizado. Erro "+ex.getMessage());   
	        }   
	        catch(Exception ex){   
	            JOptionPane.showMessageDialog(null,"Erro não definido durante o cadastro dos produtos.");   
	        }   
				
			}
					
			
			if (arg0.getSource() == jbcadastrar){
				
				try{
					
				 JOptionPane.showMessageDialog(null,"Cadastrando...");  
 	            Class.forName("com.mysql.jdbc.Driver"); 	     
	            Connection c = DriverManager.getConnection("jdbc:mysql://192.168.50.100/java10102013", "root", "suporte");   
	            Statement stm = c.createStatement();  
	            
	            if (jtnome.getText() == null | jtemail.getText() == null | jtbairro.getText() == null | jtendereco.getText() == null){
				JOptionPane.showMessageDialog(null, "Algum campo não foi preenchido.");   	
			}
				
	            String nome = jtnome.getText();
	            String email = jtemail.getText();
	            String endereco = jtendereco.getText();
	            String bairro = jtbairro.getText(); 
	            
	            stm.executeUpdate("insert into cadastro (nome,email,endereco,bairro) values ('"+nome+"','"+email+"','"+endereco+"','"+bairro+"')");   
	            JOptionPane.showMessageDialog(null, "Dados salvos com sucesso.");  
					
				}
				
				catch(SQLException ex){   
	            JOptionPane.showMessageDialog(null,"Ocorreu um erro no Banco de Dados utilizado. Erro "+ex.getMessage());   
	        }   
	        catch(Exception ex){   
	            JOptionPane.showMessageDialog(null,"Erro não definido durante o cadastro dos produtos.");   
	        }   
				
				
				
				
				
			} 
         
         if (arg0.getSource() == jblimpar){
		
		jtnome.setText("");
		jtemail.setText("");
		jtendereco.setText("");
		jtbairro.setText("");
			 
		 }
		 
         if (arg0.getSource() == jbfechar){
			 cadastro.setVisible(false);
		 }
		 
		 if (arg0.getSource() ==  jlpesquisar){
			
		    	jbconsultar.addActionListener(this);
				cadastro.setVisible(true);
				cadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
				cadastro.setLayout(null);
				jlnome.setBounds(18,18,100,30);
				jtnome.setBounds(100,18,100,30);
				jlemail.setBounds(18,60,100,30);
				jtemail.setBounds(100,60,100,30);
				jlendereco.setBounds(18,120,100,30);
				jtendereco.setBounds(100,120,100,30);
				jbconsultar.setBounds(100,220,200,30);
				jlbairro.setBounds(18,150,100,30);
				jtbairro.setBounds(100,150,100,30);
				jblimpar.setBounds(290,220,200,30);
				cadastro.add(jlnome);
				cadastro.add(jtnome);
				cadastro.add(jlemail);
				cadastro.add(jtemail);
				cadastro.add(jlendereco);
				cadastro.add(jtendereco);
				cadastro.add(jlbairro);
				cadastro.add(jtbairro);
				cadastro.add(jbconsultar);
				cadastro.add(jbfechar);
				cadastro.add(jblimpar);
				 
			 
			 
		 }
		 
		 if (arg0.getSource() == jbconsultar){
		
				try{
				
 	            Class.forName("com.mysql.jdbc.Driver"); 	     
	            Connection c = DriverManager.getConnection("jdbc:mysql://192.168.50.100/java10102013", "root", "suporte");   
	            Statement stm = c.createStatement();  
	            
	            if (jtnome.getText() == null | jtemail.getText() == null | jtbairro.getText() == null | jtendereco.getText() == null){
				JOptionPane.showMessageDialog(null, "Algum campo não foi preenchido.");   	
			}
				
	            String nome = jtnome.getText();
	            String email = jtemail.getText();
	            String endereco = jtendereco.getText();
	            String bairro = jtbairro.getText(); 
	            String sql="select * from cadastro where nome like '"+ "%" + nome + "%" + "'";
	            ResultSet rs = stm.executeQuery(sql);   
	            
					
				}
				
				catch(SQLException ex){   
	            JOptionPane.showMessageDialog(null,"Ocorreu um erro no Banco de Dados utilizado. Erro "+ex.getMessage());   
	        }   
	        catch(Exception ex){   
	            JOptionPane.showMessageDialog(null,"Erro não definido durante o cadastro dos produtos.");   
	        }   
				 
			 
			 
			 
		 }
		 
		 
         
	    }   
	}  
