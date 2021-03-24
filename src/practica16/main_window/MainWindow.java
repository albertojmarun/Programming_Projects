/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica16.main_window;

import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import practica16.library.Book;
import practica16.library.Library;

/**
 * This class is about a Window for a Library.
 * @version 1.0
 * @author Alberto J. Marun I.
 * @date March 2021.
 */
public class MainWindow extends javax.swing.JFrame {
    private final Library library;
    private final DefaultTableModel my_library;
    
    /**
     * Creates new form MainWindow.
     */
    public MainWindow() {
        initComponents();
        library = new Library();
        my_library = (DefaultTableModel) libraryTable.getModel();
        my_library.addColumn("Titulo");
        my_library.addColumn("Autor");
    }
    
    /**
     * Return the selected age for the book.
     * @return (String) The age at which the book is directed.
     */
    private String getSelectedAge(){
        String selected_age = null;
        
        if(ageChild.isSelected()){
            selected_age = "Infantil";
        } else if(agePlusSeven.isSelected()){
            selected_age = "Mayores de 7 años";
        } else if(agePlusTwelve.isSelected()){
            selected_age = "Mayores de 12 años";
        } else if(ageAdult.isSelected()){
            selected_age = "Adulto";
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
            selected_genres.add("Fantasía");
        } 
        
        // The radio button of the Horror genre.
        if(genreHorror.isSelected()){
            selected_genres.add("Horror");
        }
        
        // The radio button of the Comedy genre.
        if(genreComedy.isSelected()){
            selected_genres.add("Comedia");
        }
        
        // The radio button of the Romance genre.
        if(genreRomance.isSelected()){
            selected_genres.add("Romance");
        } 
        
        return selected_genres;
    }
    
    /**
     * This function reset the Table inside the JFrame MainWindow
     *  and clear all the rows, add one book per row,
     *  and stablish that every cell added is non-editable.
     */
    private void updateTable(){
        // Erase all the Rows inside the Table.
        my_library.setRowCount(0);
        
        // Introduce every book inside the library.
        for(int i = 0; i < library.getBooks().size(); i++){
            my_library.addRow(library.getBooks(i).toArray());
            
            // Stablish that every cell introduced to the table is non-editable.
            for(int j = 0; j < my_library.getColumnCount(); j++){
                my_library.isCellEditable(i, j);
            }
        }
    }
    
    /**
     * Select all the attributes of a Book and transform it into an String array,
     * With the following schema:
     *  [0] Book Title
     *  [1] Book Author
     *  [2] Book Editorial
     *  [3] Book Age Public
     *  [4] Book Genres
     * @return (String[]) An array of String with the Information of the selected Book at the moment.
     */
    public String[] toArray(){
        String[] book_information_selected = new String[5];
        
        if(libraryTable.getSelectedRow() != -1){
            book_information_selected[0] = library.getBooks(libraryTable.getSelectedRow()).getTitle();
            book_information_selected[1] = library.getBooks(libraryTable.getSelectedRow()).getAuthor();
            book_information_selected[2] = library.getBooks(libraryTable.getSelectedRow()).getEditorial();
            book_information_selected[3] = library.getBooks(libraryTable.getSelectedRow()).getAge();
            book_information_selected[4] = String.join("-", library.getBooks(libraryTable.getSelectedRow()).getGenres());
        }
        
        return book_information_selected;
    }
    
    
    /**
     * This function check if the extension of the file is the correct one
     * @param file_path (String) Absolute path of the file
     * @return (int) Number that stablish which is the situation that correspond
     * to the extension of the file.
     */
    private int checkFile(String file_path){
        /**
         * [-1] The "." of the file_path is at the beggining or the extension of the file is not ".dat"
         * [0]  Add to the file_path ".dat"
         * [1]  The extension of the file is ".dat".
         */
        int file_situation;
        
        if(file_path.lastIndexOf("/") != -1){
            file_path = file_path.substring(file_path.lastIndexOf("/") + 1);
        } else if(file_path.lastIndexOf("\\") != -1){
            file_path = file_path.substring(file_path.lastIndexOf("\\") + 1);
        } else{
            file_situation = -1;
        }
        
        // This means it doesn't contains the "."
        if(file_path.lastIndexOf(".") == -1 && file_path.length() > 0){
            // file_path += ".dat";
            file_situation = 0;
            
            // This means the "." is at the first character of the file.    
        } else if(file_path.lastIndexOf(".") == 0){
            file_situation = -1;
            
            // The "." of the path of the file exist and it is not the first character.
        } else{
            
            // The extension of the file is ".dat".
            if(file_path.substring(file_path.lastIndexOf(".") + 1).equals("dat")){
                file_situation = 1;
                
            // The extension of the file is not ".dat".    
            } else{
                file_situation = -1;
            }
        }
        
        return file_situation;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ageSelection = new javax.swing.ButtonGroup();
        northPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelsTitleAuthorInputs = new javax.swing.JPanel();
        bookTitleLabel = new javax.swing.JLabel();
        bookTitleInput = new javax.swing.JTextField();
        bookAuthorLabel = new javax.swing.JLabel();
        bookAuthorInput = new javax.swing.JTextField();
        centerPanel = new javax.swing.JPanel();
        editorialLayout = new javax.swing.JPanel();
        labelEditorial = new javax.swing.JLabel();
        editorialOptions = new javax.swing.JComboBox<>();
        layoutAgeLiteraryType = new javax.swing.JPanel();
        agePanel = new javax.swing.JPanel();
        labelAge = new javax.swing.JLabel();
        ageOptionsPanel = new javax.swing.JPanel();
        ageChild = new javax.swing.JRadioButton();
        agePlusSeven = new javax.swing.JRadioButton();
        agePlusTwelve = new javax.swing.JRadioButton();
        ageAdult = new javax.swing.JRadioButton();
        literaryPanel = new javax.swing.JPanel();
        labelGenres = new javax.swing.JLabel();
        genresPanel = new javax.swing.JPanel();
        genreFantasy = new javax.swing.JCheckBox();
        genreHorror = new javax.swing.JCheckBox();
        genreComedy = new javax.swing.JCheckBox();
        genreRomance = new javax.swing.JCheckBox();
        layoutButtons = new javax.swing.JPanel();
        addBookButton = new javax.swing.JButton();
        removeBookButton = new javax.swing.JButton();
        buttonShowBook = new javax.swing.JButton();
        southPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        libraryTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFiles = new javax.swing.JMenu();
        menuExportLibrary = new javax.swing.JMenuItem();
        menuImportLibrary = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Biblioteca MEDAC");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(500, 760));

        northPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10), null));
        northPanel.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BIBLIOTECA");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        northPanel.add(jLabel1, java.awt.BorderLayout.NORTH);

        panelsTitleAuthorInputs.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 40, 20, 40));
        panelsTitleAuthorInputs.setLayout(new java.awt.GridLayout(2, 0, 10, 40));

        bookTitleLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bookTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bookTitleLabel.setText("Titulo Del Libro:");
        bookTitleLabel.setRequestFocusEnabled(false);
        panelsTitleAuthorInputs.add(bookTitleLabel);

        bookTitleInput.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bookTitleInput.setToolTipText("");
        bookTitleInput.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20)));
        panelsTitleAuthorInputs.add(bookTitleInput);

        bookAuthorLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bookAuthorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bookAuthorLabel.setText("Autor del Libro:");
        panelsTitleAuthorInputs.add(bookAuthorLabel);

        bookAuthorInput.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bookAuthorInput.setToolTipText("");
        bookAuthorInput.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20)));
        panelsTitleAuthorInputs.add(bookAuthorInput);

        northPanel.add(panelsTitleAuthorInputs, java.awt.BorderLayout.CENTER);

        getContentPane().add(northPanel, java.awt.BorderLayout.NORTH);

        centerPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 40, 1, 40));
        centerPanel.setLayout(new java.awt.BorderLayout());

        editorialLayout.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 80, 40, 80));
        editorialLayout.setToolTipText("");
        editorialLayout.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 40, 5));

        labelEditorial.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelEditorial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEditorial.setText("Editorial del Libro:");
        editorialLayout.add(labelEditorial);

        editorialOptions.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        editorialOptions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Panini Comics", "NAVONA PERESUR", "MALPASOYCIA", "Astiberri Edici", "MAxEstrellaEdic" }));
        editorialOptions.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10), null));
        editorialOptions.setMaximumSize(new java.awt.Dimension(32767, 45));
        editorialOptions.setMinimumSize(new java.awt.Dimension(245, 45));
        editorialLayout.add(editorialOptions);

        centerPanel.add(editorialLayout, java.awt.BorderLayout.NORTH);

        layoutAgeLiteraryType.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 40, 1, 40));
        layoutAgeLiteraryType.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 25, 0));

        agePanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        agePanel.setLayout(new java.awt.BorderLayout());

        labelAge.setFont(new java.awt.Font(".SF NS Text", 0, 14)); // NOI18N
        labelAge.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelAge.setText("Edad:");
        labelAge.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        labelAge.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 1, 1, 5));
        labelAge.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        agePanel.add(labelAge, java.awt.BorderLayout.NORTH);

        ageOptionsPanel.setLayout(new java.awt.GridLayout(4, 0));

        ageSelection.add(ageChild);
        ageChild.setText("Infantil.");
        ageChild.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 1, 1, 5));
        ageChild.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ageOptionsPanel.add(ageChild);

        ageSelection.add(agePlusSeven);
        agePlusSeven.setText("Mayores de 7 Años.");
        agePlusSeven.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 1, 1, 5));
        agePlusSeven.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ageOptionsPanel.add(agePlusSeven);

        ageSelection.add(agePlusTwelve);
        agePlusTwelve.setText("Mayores de 12 Años.");
        agePlusTwelve.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 1, 1, 5));
        agePlusTwelve.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        agePlusTwelve.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ageOptionsPanel.add(agePlusTwelve);

        ageSelection.add(ageAdult);
        ageAdult.setText("Adultos.");
        ageAdult.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 1, 1, 5));
        ageAdult.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ageOptionsPanel.add(ageAdult);

        agePanel.add(ageOptionsPanel, java.awt.BorderLayout.CENTER);

        layoutAgeLiteraryType.add(agePanel);

        literaryPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        literaryPanel.setLayout(new java.awt.BorderLayout());

        labelGenres.setFont(new java.awt.Font(".SF NS Text", 0, 14)); // NOI18N
        labelGenres.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelGenres.setText("Estilo Literario:");
        labelGenres.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        labelGenres.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 1, 1, 5));
        literaryPanel.add(labelGenres, java.awt.BorderLayout.NORTH);

        genresPanel.setLayout(new java.awt.GridLayout(4, 0));

        genreFantasy.setText("Fantasía");
        genreFantasy.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 1, 1, 5));
        genresPanel.add(genreFantasy);

        genreHorror.setText("Terror");
        genreHorror.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 1, 1, 5));
        genresPanel.add(genreHorror);

        genreComedy.setText("Comedia");
        genreComedy.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 1, 1, 5));
        genresPanel.add(genreComedy);

        genreRomance.setText("Romance");
        genreRomance.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 1, 1, 5));
        genresPanel.add(genreRomance);

        literaryPanel.add(genresPanel, java.awt.BorderLayout.CENTER);

        layoutAgeLiteraryType.add(literaryPanel);

        centerPanel.add(layoutAgeLiteraryType, java.awt.BorderLayout.CENTER);

        layoutButtons.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 80, 10, 80));
        layoutButtons.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 50, 5));

        addBookButton.setText("Añadir");
        addBookButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBookButtonActionPerformed(evt);
            }
        });
        layoutButtons.add(addBookButton);

        removeBookButton.setText("Eliminar");
        removeBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBookButtonActionPerformed(evt);
            }
        });
        layoutButtons.add(removeBookButton);

        buttonShowBook.setText("Mostrar Libro");
        buttonShowBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonShowBookActionPerformed(evt);
            }
        });
        layoutButtons.add(buttonShowBook);

        centerPanel.add(layoutButtons, java.awt.BorderLayout.SOUTH);

        getContentPane().add(centerPanel, java.awt.BorderLayout.CENTER);

        southPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        southPanel.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setMaximumSize(new java.awt.Dimension(32767, 600));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(400, 200));

        libraryTable = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        libraryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(libraryTable);

        southPanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(southPanel, java.awt.BorderLayout.SOUTH);

        menuFiles.setText("Ficheros");

        menuExportLibrary.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuExportLibrary.setText("Exportar Biblioteca");
        menuExportLibrary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExportLibraryActionPerformed(evt);
            }
        });
        menuFiles.add(menuExportLibrary);

        menuImportLibrary.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuImportLibrary.setText("Importar Biblioteca");
        menuImportLibrary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuImportLibraryActionPerformed(evt);
            }
        });
        menuFiles.add(menuImportLibrary);

        jMenuBar1.add(menuFiles);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * The functionability of this is to clear all the check boxes
     * that are selected, when the Book is selected.
     */
    private void clearCheckBoxes(){
        // The radio button of the Fantasy genre.
        if(genreFantasy.isSelected()){
            genreFantasy.setSelected(false);
        } 
        
        // The radio button of the Horror genre.
        if(genreHorror.isSelected()){
            genreHorror.setSelected(false);
        }
        
        // The radio button of the Comedy genre.
        if(genreComedy.isSelected()){
            genreComedy.setSelected(false);
        }
        
        // The radio button of the Romance genre.
        if(genreRomance.isSelected()){
            genreRomance.setSelected(false);
        }
    }
    
    /**
     * This function corresponds to add a book to the Library and update the Table.
     * @param evt (ActionEvent) When the user press the add button this function turns on.
     */
    private void addBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBookButtonActionPerformed
        // TODO add your handling code here:
        Book new_book = new Book();
        
        new_book.setTitle(bookTitleInput.getText());
        new_book.setAuthor(bookAuthorInput.getText());
        new_book.setEditorial(editorialOptions.getSelectedItem().toString());
        new_book.setAge(getSelectedAge());
        new_book.setGenres(getSelectedGenres());
            
        if(new_book.isValid()){
            bookTitleInput.setText("");
            bookAuthorInput.setText("");
            ageSelection.clearSelection();
            this.clearCheckBoxes();
            
            library.addBook(new_book);
            updateTable();
            
        } else{
            JOptionPane.showMessageDialog(this, "La información del Libro es Inválida", "LIBRO NO VÁLIDO", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_addBookButtonActionPerformed

    /**
     * Remove the selected book on the Table.
     * @param evt (ActionEvent) When the Remove Button is pressed it activates.
     */
    private void removeBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBookButtonActionPerformed
        // TODO add your handling code here:
        String remove_confirmation;
        String[] options = {"No", "Si"};
        int selected_option;
        
        if(libraryTable.getSelectedRow() != -1){
            remove_confirmation = "¿Estás seguro que deseas eliminar el libro " + library.getBooks(libraryTable.getSelectedRow()).getTitle() + "?";
            
            selected_option = JOptionPane.showOptionDialog(this, remove_confirmation, "ELIMINAR LIBRO", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, "No");
            
            if(selected_option == 0){
                library.removeBook(libraryTable.getSelectedRow());
                updateTable();   
            }
            
        } else{
            JOptionPane.showMessageDialog(this, "Ninguna fila ha sido seleccionada", "ERROR: NINGUNA FILA SELECCIONADA", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_removeBookButtonActionPerformed

    /**
     * To Export the Library that the program already has.
     * @param evt (ActionEvent) When the user press the Option or do the
     *  corresponded combination of keys on the keyboard.
     */
    private void menuExportLibraryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExportLibraryActionPerformed
        JFileChooser selected_file = new JFileChooser();
        FileNameExtensionFilter extension = new FileNameExtensionFilter("Ficheros Binarios", "dat");
        String path;
        int extension_option;
        
        selected_file.setAcceptAllFileFilterUsed(false);
        selected_file.addChoosableFileFilter(extension);
        
        if(selected_file.showDialog(this, "Seleccionado") == JFileChooser.APPROVE_OPTION){
            path = selected_file.getSelectedFile().getAbsolutePath();
            
            extension_option = this.checkFile(path);
            
            if(extension_option == 0 || extension_option == 1){
                if(extension_option == 0){
                    path += ".dat";
                }
                
                try{
                    library.writeFile(path);
                    this.updateTable();

                } catch (Exception error){
                    JOptionPane.showMessageDialog(this, error.getMessage(), "ERROR EXPORTANDO LA LIBRERIA", JOptionPane.WARNING_MESSAGE);
                }
            } else{
                JOptionPane.showMessageDialog(this, "La extensión del Documento es Invalida", "EXTENSION NO VALIDA", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_menuExportLibraryActionPerformed
    
    /**
     * Import a Library that comes from a Binary File
     * @param evt (ActionEvent) When the user press the Option or do the
     *  corresponded combination of keys on the keyboard.
     */
    private void menuImportLibraryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuImportLibraryActionPerformed
        // TODO add your handling code here:
        JFileChooser selected_file = new JFileChooser();
        FileNameExtensionFilter extension = new FileNameExtensionFilter("Ficheros Binarios", "dat");
        String path;
        int extension_option;
        
        selected_file.setAcceptAllFileFilterUsed(false);
        selected_file.addChoosableFileFilter(extension);
        
        selected_file.setDialogTitle("BUSCA UN FICHERO");
        
        if(selected_file.showDialog(this, "Seleccionado") == JFileChooser.APPROVE_OPTION){
            path = selected_file.getSelectedFile().getAbsolutePath();
            
            extension_option = this.checkFile(path);
            
            if(extension_option == 0 || extension_option == 1){
                
                if(extension_option == 0){
                    path += ".dat";
                }
                
                try{
                    library.readFile(path);
                    this.updateTable();

                } catch (Exception error){
                    JOptionPane.showMessageDialog(this, error.getMessage(), "ERROR IMPORTANDO LA LIBRERIA", JOptionPane.WARNING_MESSAGE);
                }
                
            }  else{
                JOptionPane.showMessageDialog(this, "La extensión del Documento es Invalida", "EXTENSION NO VALIDA", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_menuImportLibraryActionPerformed

    /**
     * Show the selected book on a new Window with all of his attributes.
     * @param evt (ActionEvent) When the user press the button, activate this function.
     */
    private void buttonShowBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonShowBookActionPerformed
        // TODO add your handling code here:
        BookInformationWindow book_window = new BookInformationWindow(this);
        
        if(libraryTable.getSelectedRow() != -1){
            book_window.setVisible(true);
        } else{
            JOptionPane.showMessageDialog(this, "Ninguna fila ha sido seleccionada", "ERROR: NINGUNA FILA SELECCIONADA", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_buttonShowBookActionPerformed
    
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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBookButton;
    private javax.swing.JRadioButton ageAdult;
    private javax.swing.JRadioButton ageChild;
    private javax.swing.JPanel ageOptionsPanel;
    private javax.swing.JPanel agePanel;
    private javax.swing.JRadioButton agePlusSeven;
    private javax.swing.JRadioButton agePlusTwelve;
    private javax.swing.ButtonGroup ageSelection;
    private javax.swing.JTextField bookAuthorInput;
    private javax.swing.JLabel bookAuthorLabel;
    private javax.swing.JTextField bookTitleInput;
    private javax.swing.JLabel bookTitleLabel;
    private javax.swing.JButton buttonShowBook;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JPanel editorialLayout;
    private javax.swing.JComboBox<String> editorialOptions;
    private javax.swing.JCheckBox genreComedy;
    private javax.swing.JCheckBox genreFantasy;
    private javax.swing.JCheckBox genreHorror;
    private javax.swing.JCheckBox genreRomance;
    private javax.swing.JPanel genresPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAge;
    private javax.swing.JLabel labelEditorial;
    private javax.swing.JLabel labelGenres;
    private javax.swing.JPanel layoutAgeLiteraryType;
    private javax.swing.JPanel layoutButtons;
    private javax.swing.JTable libraryTable;
    private javax.swing.JPanel literaryPanel;
    private javax.swing.JMenuItem menuExportLibrary;
    private javax.swing.JMenu menuFiles;
    private javax.swing.JMenuItem menuImportLibrary;
    private javax.swing.JPanel northPanel;
    private javax.swing.JPanel panelsTitleAuthorInputs;
    private javax.swing.JButton removeBookButton;
    private javax.swing.JPanel southPanel;
    // End of variables declaration//GEN-END:variables
}