/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica18.main_window;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import practica18.library.Book;
import static practica18.main_window.MainWindow.*;

/**
 * This class is about a Window to Modify the Information of an Specific Book.
 * @version 1.0
 * @author Alberto J. Marun I.
 * @date April 2021.
 */
public class EditBookWindow extends javax.swing.JDialog {
    private final MainWindow parent_window;
    private final Book editing_book;
    
    /**
     * Creates new form EditBookWindow.
     * @param parent (MainWindow) JFrame that is the parent of the EditBookWindow.
     * @param book (Book) Book to edit the information.
     */
    public EditBookWindow(MainWindow parent, Book book) {
        super(parent, true);
        parent_window = parent;
        editing_book = book; 
        initComponents();
        assignBookInformation();
    }
    
    /**
     * Assign all the values of the Book to the whole Labels.
     */
    private void assignBookInformation(){
        this.input_title.setText(editing_book.getTitle());
        this.input_author.setText(editing_book.getAuthor());
        this.editorialOptions.setSelectedItem(editing_book.getEditorial());
        this.assignAge(editing_book.getAge());
        this.assignGenres(editing_book.getGenresAsString());
    }
    
    /**
     * Selected the age who is directed the book.
     * @param book_age (String) Current value of the Age who is directed the Book.
     */
    private void assignAge(String book_age){
        switch(book_age){
            case (MainWindow.CHILD_AGE_ES):
                ageChild.setSelected(true);
                break;
                
            case (MainWindow.SEVEN_AGE_ES):
                agePlusSeven.setSelected(true);
                break;
                
            case (MainWindow.TWELVE_AGE_ES):
                agePlusTwelve.setSelected(true);
                break;
                
            case (MainWindow.ADULT_AGE_ES):
                ageAdult.setSelected(true);
                break;
        }
    }
    
    /**
     * Assign the Genres to the Window.
     * @param book_genres (String) Actual genres of the book.
     */
    private void assignGenres(String book_genres) {
        
        if(book_genres.contains(MainWindow.FANTASY_GENRE_ES)){
            genreFantasy.setSelected(true);
        }
        
        if(book_genres.contains(MainWindow.HORROR_GENRE_ES)){
            genreHorror.setSelected(true);
        }
        
        if(book_genres.contains(MainWindow.COMEDY_GENRE_ES)){
            genreComedy.setSelected(true);
        }
        
        if(book_genres.contains(MainWindow.ROMANCE_GENRE_ES)){
            genreRomance.setSelected(true);
        }
    }
    
    /**
     * Return the selected age for the book.
     * @return (String) The age at which the book is directed.
     */
    private String getSelectedAge(){
        String selected_age = null;
        
        if(ageChild.isSelected()){
            selected_age = CHILD_AGE_ES;
            
        } else if(agePlusSeven.isSelected()){
            selected_age = SEVEN_AGE_ES;
            
        } else if(agePlusTwelve.isSelected()){
            selected_age = TWELVE_AGE_ES;
            
        } else if(ageAdult.isSelected()){
            selected_age = ADULT_AGE_ES;
        }
        
        return selected_age;
    }
    
    /**
     * Return all the selected genres for a book.
     * @return (ArrayList<String>) An array list with the selected genres.
     */
    private ArrayList<String> getSelectedGenres(){
        ArrayList<String> selected_genres = new ArrayList<>();
        
        // The radio button of the Fantasy genre.
        if(genreFantasy.isSelected()){
            selected_genres.add(FANTASY_GENRE_ES);
        } 
        
        // The radio button of the Horror genre.
        if(genreHorror.isSelected()){
            selected_genres.add(HORROR_GENRE_ES);
        }
        
        // The radio button of the Comedy genre.
        if(genreComedy.isSelected()){
            selected_genres.add(COMEDY_GENRE_ES);
        }
        
        // The radio button of the Romance genre.
        if(genreRomance.isSelected()){
            selected_genres.add(ROMANCE_GENRE_ES);
        }
        
        return selected_genres;
    }
    
    /**
     * Assign new values to the Book attributes.
     */
    private void editBookInformation(){
        editing_book.setTitle(input_title.getText());
        editing_book.setAuthor(input_author.getText());
        
        if(editorialOptions.getSelectedIndex() != 0){
            editing_book.setEditorial(editorialOptions.getSelectedItem().toString());
        }
        
        editing_book.setAge(getSelectedAge());
        editing_book.setGenres(String.join(" - ", getSelectedGenres()));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button_group_age = new javax.swing.ButtonGroup();
        label_title = new javax.swing.JLabel();
        panel_input_title = new javax.swing.JPanel();
        input_title = new javax.swing.JTextField();
        label_author = new javax.swing.JLabel();
        panel_input_author = new javax.swing.JPanel();
        input_author = new javax.swing.JTextField();
        label_editorial = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        editorialOptions = new javax.swing.JComboBox<>();
        label_age = new javax.swing.JLabel();
        panel_age = new javax.swing.JPanel();
        ageChild = new javax.swing.JRadioButton();
        agePlusSeven = new javax.swing.JRadioButton();
        agePlusTwelve = new javax.swing.JRadioButton();
        ageAdult = new javax.swing.JRadioButton();
        label_literary_gender = new javax.swing.JLabel();
        panel_literary_gender = new javax.swing.JPanel();
        genreFantasy = new javax.swing.JCheckBox();
        genreHorror = new javax.swing.JCheckBox();
        genreComedy = new javax.swing.JCheckBox();
        genreRomance = new javax.swing.JCheckBox();
        panel_cancel_button = new javax.swing.JPanel();
        button_cancel = new javax.swing.JButton();
        panel_accept_button = new javax.swing.JPanel();
        button_accept = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar: " + editing_book.getTitle());
        setMinimumSize(new java.awt.Dimension(532, 900));
        getContentPane().setLayout(new java.awt.GridLayout(6, 2, 10, 40));

        label_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_title.setText("Title:");
        getContentPane().add(label_title);

        panel_input_title.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panel_input_title.setLayout(new java.awt.BorderLayout());

        input_title.setText("Titulo_Actual");
        panel_input_title.add(input_title, java.awt.BorderLayout.CENTER);

        getContentPane().add(panel_input_title);

        label_author.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_author.setText("Author:");
        getContentPane().add(label_author);

        panel_input_author.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panel_input_author.setLayout(new java.awt.BorderLayout());

        input_author.setText("Autor_Actual");
        panel_input_author.add(input_author, java.awt.BorderLayout.CENTER);

        getContentPane().add(panel_input_author);

        label_editorial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_editorial.setText("Editorial:");
        getContentPane().add(label_editorial);

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 50, 30, 50));
        jPanel1.setLayout(new java.awt.BorderLayout());

        editorialOptions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona una Editorial...", "Panini Comics", "NAVONA PERESUR", "MALPASOYCIA", "Astiberri Edici", "MAxEstrellaEdic" }));
        editorialOptions.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));
        jPanel1.add(editorialOptions, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1);

        label_age.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_age.setText("Edad:");
        getContentPane().add(label_age);

        panel_age.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 40, 1, 1));
        panel_age.setLayout(new java.awt.GridLayout(4, 0));

        button_group_age.add(ageChild);
        ageChild.setText("Infantil.");
        ageChild.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 1, 1, 5));
        ageChild.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        panel_age.add(ageChild);

        button_group_age.add(agePlusSeven);
        agePlusSeven.setText("Mayores de 7 Años.");
        agePlusSeven.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 1, 1, 5));
        agePlusSeven.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        panel_age.add(agePlusSeven);

        button_group_age.add(agePlusTwelve);
        agePlusTwelve.setText("Mayores de 12 Años.");
        agePlusTwelve.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 1, 1, 5));
        agePlusTwelve.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        agePlusTwelve.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        panel_age.add(agePlusTwelve);

        button_group_age.add(ageAdult);
        ageAdult.setText("Adultos.");
        ageAdult.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 1, 1, 5));
        ageAdult.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        panel_age.add(ageAdult);

        getContentPane().add(panel_age);

        label_literary_gender.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_literary_gender.setText("Genero Literario:");
        getContentPane().add(label_literary_gender);

        panel_literary_gender.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 40, 1, 1));
        panel_literary_gender.setLayout(new java.awt.GridLayout(4, 0));

        genreFantasy.setText("Fantasía");
        genreFantasy.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 1, 1, 5));
        panel_literary_gender.add(genreFantasy);

        genreHorror.setText("Terror");
        genreHorror.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 1, 1, 5));
        panel_literary_gender.add(genreHorror);

        genreComedy.setText("Comedia");
        genreComedy.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 1, 1, 5));
        panel_literary_gender.add(genreComedy);

        genreRomance.setText("Romance");
        genreRomance.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 1, 1, 5));
        panel_literary_gender.add(genreRomance);

        getContentPane().add(panel_literary_gender);

        panel_cancel_button.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 70, 30, 70));
        panel_cancel_button.setLayout(new java.awt.BorderLayout());

        button_cancel.setText("Cancelar");
        button_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_cancelActionPerformed(evt);
            }
        });
        panel_cancel_button.add(button_cancel, java.awt.BorderLayout.CENTER);

        getContentPane().add(panel_cancel_button);

        panel_accept_button.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 70, 30, 70));
        panel_accept_button.setLayout(new java.awt.BorderLayout());

        button_accept.setText("Aceptar");
        button_accept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_acceptActionPerformed(evt);
            }
        });
        panel_accept_button.add(button_accept, java.awt.BorderLayout.CENTER);

        getContentPane().add(panel_accept_button);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Close the window without editing the Book.
     * @param evt (ActionEvent) When the button Cancel is pressed, activate this function.
     */
    private void button_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_cancelActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_button_cancelActionPerformed

    /**
     * Modifiy the inputs of the book (with the new Information) and close the window.
     * @param evt (ActionEvent) When the button Accept is pressed, activate this function.
     */
    private void button_acceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_acceptActionPerformed
        this.editBookInformation();
        
        try{
            parent_window.editBook(editing_book);
            this.setVisible(false);
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR MODIFICANDO EL LIBRO", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_button_acceptActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton ageAdult;
    private javax.swing.JRadioButton ageChild;
    private javax.swing.JRadioButton agePlusSeven;
    private javax.swing.JRadioButton agePlusTwelve;
    private javax.swing.JButton button_accept;
    private javax.swing.JButton button_cancel;
    private javax.swing.ButtonGroup button_group_age;
    private javax.swing.JComboBox<String> editorialOptions;
    private javax.swing.JCheckBox genreComedy;
    private javax.swing.JCheckBox genreFantasy;
    private javax.swing.JCheckBox genreHorror;
    private javax.swing.JCheckBox genreRomance;
    private javax.swing.JTextField input_author;
    private javax.swing.JTextField input_title;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label_age;
    private javax.swing.JLabel label_author;
    private javax.swing.JLabel label_editorial;
    private javax.swing.JLabel label_literary_gender;
    private javax.swing.JLabel label_title;
    private javax.swing.JPanel panel_accept_button;
    private javax.swing.JPanel panel_age;
    private javax.swing.JPanel panel_cancel_button;
    private javax.swing.JPanel panel_input_author;
    private javax.swing.JPanel panel_input_title;
    private javax.swing.JPanel panel_literary_gender;
    // End of variables declaration//GEN-END:variables

}
