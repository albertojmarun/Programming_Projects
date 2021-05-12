/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica19.mainwindow;
import practica19.library.*;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 * This class is about a Window (JFrame) for a Library.
 * @version 1.0
 * @author Alberto J. Marun I.
 * @date May 2021.
 */
public class MainWindow extends javax.swing.JFrame {
    private final int NOT_SELECTED_ROW = -1;
    public static final String FANTASY_GENRE_ES = "Fantasía";
    public static final String HORROR_GENRE_ES = "Horror";
    public static final String COMEDY_GENRE_ES = "Comedia";
    public static final String ROMANCE_GENRE_ES = "Romance";
    public static final String CHILD_AGE_ES = "Infantil";
    public static final String SEVEN_AGE_ES = "Mayores de 7 Años";
    public static final String TWELVE_AGE_ES = "Mayores de 12 Años";
    public static final String ADULT_AGE_ES = "Adulto";
    
    private final DefaultTableModel my_library;
    
    /**
     * Creates new form MainWindow.
     */
    public MainWindow() {
        initComponents();
        my_library = (DefaultTableModel) libraryTable.getModel();
        
        try {
            initLibrary();
            initMainWindow();
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR ABRIENDO LA VENTANA", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }
    }
    
    /**
     * Initialize all the components on the Library and Data Base.
     * @throws Exception If there is an error connecting to the Data Base.
     */
    private void initLibrary() throws Exception{
        Library.connect();
        Library.initializeGenresFilter();
        Library.setCurrentPage(0);
        Library.setTitleAsc(true);
        Library.setAuthorFilter("");
        Library.setAgeFilter("");
    }
    
    /**
     * Initialize the components on the MainWindow with the personal values:
     *  - Clear the predetermined selection of components on Age Filter Buttons.
     *  - Select the Option of Menu_Order_Asc_Title.
     */
    private void initMainWindow(){
        age_filter_buttons.clearSelection();
        menu_order_asc_title.setSelected(true);
        this.updateTable();
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
     * Enabled and Disabled the previous page and next page buttons
     * Depending if it is on the first or last page
     * If there is less or equal 10 books, disabled both buttons.
     */
    private void focusPrevNextButtons(){
        if(Library.getCurrentPage() == Library.getLastPage()){
            button_next_page.setEnabled(false);
            next_page_menu.setEnabled(false);
        } else{
            button_next_page.setEnabled(true);
            next_page_menu.setEnabled(true);
        }
        
        if(Library.getCurrentPage() == 0){
            button_prev_page.setEnabled(false);
            previous_page_menu.setEnabled(false);
        } else{
            button_prev_page.setEnabled(true);
            previous_page_menu.setEnabled(true);
        }
    }
    
    /**
     * This function reset the Table inside the JFrame MainWindow,
     *  cleaning all the rows, add one book per row,
     *  setting the number of page if there is a change
     *  and stablish that every cell added is non-editable.
     */
    protected void updateTable(){
        // Erase all the Rows inside the Table.
        my_library.setRowCount(0);
        
        try {
            for(Book book : Library.getBooks()){
                my_library.addRow(book.toArray());
            }
            
            label_page.setText( (Library.getCurrentPage() + 1) + " de " + (Library.getLastPage() + 1) );
            
            this.focusPrevNextButtons();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e, "ERROR CARGANDO LOS LIBROS", JOptionPane.WARNING_MESSAGE);
        }
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
     * Clear all the Inputs of the Window.
     */
    private void clearInputs(){
        bookTitleInput.setText("");
        bookAuthorInput.setText("");
        editorialOptions.setSelectedIndex(0);
        ageSelection.clearSelection();
        this.clearCheckBoxes();
    }
    
    /**
     * Edit the Information of the Book Selected.
     * @param new_information Book that is changing
     * @throws Exception 
     */
    protected void editBook(Book new_information) throws Exception{
        if(new_information.isValid()){
            Library.saveBook(new_information);
            updateTable();
        } else{
            throw new Exception("Información del Libro No Válida.");
        }
    }
    
    /**
     * Clear all the check boxes from the Genres Filter Menu.
     */
    private void resetSelectedGenresFilter(){
        menu_filter_fantasy.setSelected(false);
        menu_filter_horror.setSelected(false);
        menu_filter_comedy.setSelected(false);
        menu_filter_romance.setSelected(false);
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
        author_asc_desc = new javax.swing.ButtonGroup();
        age_filter_buttons = new javax.swing.ButtonGroup();
        northPanel = new javax.swing.JPanel();
        label_biblioteca = new javax.swing.JLabel();
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
        jButton1 = new javax.swing.JButton();
        southPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        button_prev_page = new javax.swing.JButton();
        label_page = new javax.swing.JLabel();
        button_next_page = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        libraryTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFiles = new javax.swing.JMenu();
        menuExportLibrary = new javax.swing.JMenuItem();
        menuImportLibrary = new javax.swing.JMenuItem();
        menu_empty_library = new javax.swing.JMenuItem();
        menu_order_title = new javax.swing.JMenu();
        menu_current_page = new javax.swing.JMenu();
        previous_page_menu = new javax.swing.JMenuItem();
        next_page_menu = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        menu_order_asc_title = new javax.swing.JRadioButtonMenuItem();
        menu_order_desc_title = new javax.swing.JRadioButtonMenuItem();
        menu_author_filter = new javax.swing.JMenuItem();
        menu_genres_filter = new javax.swing.JMenu();
        menu_filter_fantasy = new javax.swing.JCheckBoxMenuItem();
        menu_filter_horror = new javax.swing.JCheckBoxMenuItem();
        menu_filter_comedy = new javax.swing.JCheckBoxMenuItem();
        menu_filter_romance = new javax.swing.JCheckBoxMenuItem();
        reset_genres_filter = new javax.swing.JMenuItem();
        menu_filter_age = new javax.swing.JMenu();
        button_age_filter_infantil = new javax.swing.JRadioButtonMenuItem();
        button_age_filter_seven = new javax.swing.JRadioButtonMenuItem();
        button_age_filter_twelve = new javax.swing.JRadioButtonMenuItem();
        button_age_filter_adult = new javax.swing.JRadioButtonMenuItem();
        button_age_filter_reset = new javax.swing.JMenuItem();
        menu_filter_reset = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Practica 19");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(870, 810));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.BorderLayout(10, 10));

        northPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10), null));
        northPanel.setLayout(new java.awt.BorderLayout());

        label_biblioteca.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        label_biblioteca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_biblioteca.setText("BIBLIOTECA");
        label_biblioteca.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        label_biblioteca.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        northPanel.add(label_biblioteca, java.awt.BorderLayout.NORTH);

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

        editorialLayout.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 80, 15, 80));
        editorialLayout.setToolTipText("");
        editorialLayout.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 40, 5));

        labelEditorial.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelEditorial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEditorial.setText("Editorial del Libro:");
        editorialLayout.add(labelEditorial);

        editorialOptions.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        editorialOptions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona una Editorial...", "Panini Comics", "NAVONA PERESUR", "MALPASOYCIA", "Astiberri Edici", "MAxEstrellaEdic" }));
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
                deleteBookButtonActionPerformed(evt);
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

        jButton1.setText("Editar Libro");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBookButton(evt);
            }
        });
        layoutButtons.add(jButton1);

        centerPanel.add(layoutButtons, java.awt.BorderLayout.SOUTH);

        getContentPane().add(centerPanel, java.awt.BorderLayout.CENTER);

        southPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        southPanel.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        button_prev_page.setText("<- Página Anterior");
        button_prev_page.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_prev_pageActionPerformed(evt);
            }
        });
        jPanel1.add(button_prev_page);

        label_page.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_page.setText("CurrentPage de LastPage");
        jPanel1.add(label_page);

        button_next_page.setText("Siguiente Página ->");
        button_next_page.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_next_pageActionPerformed(evt);
            }
        });
        jPanel1.add(button_next_page);

        southPanel.add(jPanel1, java.awt.BorderLayout.NORTH);

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
                "Titulo", "Autor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(libraryTable);

        southPanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(southPanel, java.awt.BorderLayout.SOUTH);

        menuFiles.setText("Ficheros");
        menuFiles.setMinimumSize(new java.awt.Dimension(870, 790));

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

        menu_empty_library.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        menu_empty_library.setText("Vaciar Libreria");
        menu_empty_library.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_empty_libraryActionPerformed(evt);
            }
        });
        menuFiles.add(menu_empty_library);

        jMenuBar1.add(menuFiles);

        menu_order_title.setText("Ordenar Libro");

        menu_current_page.setText("Página Actual");

        previous_page_menu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_LEFT, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        previous_page_menu.setText("Pagina Anterior");
        previous_page_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previous_page_menuActionPerformed(evt);
            }
        });
        menu_current_page.add(previous_page_menu);

        next_page_menu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_RIGHT, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        next_page_menu.setText("Pagina Posterior");
        next_page_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next_page_menuActionPerformed(evt);
            }
        });
        menu_current_page.add(next_page_menu);

        menu_order_title.add(menu_current_page);

        jMenu1.setText("Titulo");

        menu_order_asc_title.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        author_asc_desc.add(menu_order_asc_title);
        menu_order_asc_title.setText("Orden Ascendente");
        menu_order_asc_title.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_order_asc_titleActionPerformed(evt);
            }
        });
        jMenu1.add(menu_order_asc_title);

        menu_order_desc_title.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        author_asc_desc.add(menu_order_desc_title);
        menu_order_desc_title.setSelected(true);
        menu_order_desc_title.setText("Orden Descendente");
        menu_order_desc_title.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_order_desc_titleActionPerformed(evt);
            }
        });
        jMenu1.add(menu_order_desc_title);

        menu_order_title.add(jMenu1);

        menu_author_filter.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menu_author_filter.setText("Autor");
        menu_author_filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_author_filterActionPerformed(evt);
            }
        });
        menu_order_title.add(menu_author_filter);

        menu_genres_filter.setText("Estilo Literario");

        menu_filter_fantasy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menu_filter_fantasy.setText("Fantasía");
        menu_filter_fantasy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_filter_fantasyActionPerformed(evt);
            }
        });
        menu_genres_filter.add(menu_filter_fantasy);

        menu_filter_horror.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menu_filter_horror.setText("Terror");
        menu_filter_horror.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_filter_horrorActionPerformed(evt);
            }
        });
        menu_genres_filter.add(menu_filter_horror);

        menu_filter_comedy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menu_filter_comedy.setText("Comedia");
        menu_filter_comedy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_filter_comedyActionPerformed(evt);
            }
        });
        menu_genres_filter.add(menu_filter_comedy);

        menu_filter_romance.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menu_filter_romance.setText("Romance");
        menu_filter_romance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_filter_romanceActionPerformed(evt);
            }
        });
        menu_genres_filter.add(menu_filter_romance);

        reset_genres_filter.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        reset_genres_filter.setText("Limpiar Filtro Generos");
        reset_genres_filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_genres_filterActionPerformed(evt);
            }
        });
        menu_genres_filter.add(reset_genres_filter);

        menu_order_title.add(menu_genres_filter);

        menu_filter_age.setText("Edad");

        button_age_filter_infantil.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        age_filter_buttons.add(button_age_filter_infantil);
        button_age_filter_infantil.setText("Infantil");
        button_age_filter_infantil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_age_filter_infantilActionPerformed(evt);
            }
        });
        menu_filter_age.add(button_age_filter_infantil);

        button_age_filter_seven.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        age_filter_buttons.add(button_age_filter_seven);
        button_age_filter_seven.setText("Mayores de 7 Años");
        button_age_filter_seven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_age_filter_sevenActionPerformed(evt);
            }
        });
        menu_filter_age.add(button_age_filter_seven);

        button_age_filter_twelve.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        age_filter_buttons.add(button_age_filter_twelve);
        button_age_filter_twelve.setText("Mayores de 12 Años");
        button_age_filter_twelve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_age_filter_twelveActionPerformed(evt);
            }
        });
        menu_filter_age.add(button_age_filter_twelve);

        button_age_filter_adult.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        age_filter_buttons.add(button_age_filter_adult);
        button_age_filter_adult.setText("Adultos");
        button_age_filter_adult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_age_filter_adultActionPerformed(evt);
            }
        });
        menu_filter_age.add(button_age_filter_adult);

        button_age_filter_reset.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        button_age_filter_reset.setText("Reiniciar Edad");
        button_age_filter_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_age_filter_resetActionPerformed(evt);
            }
        });
        menu_filter_age.add(button_age_filter_reset);

        menu_order_title.add(menu_filter_age);

        menu_filter_reset.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menu_filter_reset.setText("Limpiar Filtros");
        menu_filter_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_filter_resetActionPerformed(evt);
            }
        });
        menu_order_title.add(menu_filter_reset);

        jMenuBar1.add(menu_order_title);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * This function corresponds to add a book to the Library and update the Table.
     * @param evt (ActionEvent) When the user press the add button this function turns on.
     */
    private void addBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBookButtonActionPerformed
        // TODO add your handling code here:
        Book new_book = new Book();
        
        new_book.setTitle(bookTitleInput.getText());
        new_book.setAuthor(bookAuthorInput.getText());

        if(editorialOptions.getSelectedIndex() != 0){
            new_book.setEditorial(editorialOptions.getSelectedItem().toString());
        }
        
        new_book.setAge(getSelectedAge());
        new_book.setGenres(getSelectedGenres());
            
        
        try{
            if(new_book.isValid()){
                Library.saveBook(new_book);
                this.clearInputs();
                updateTable();

            } else{
                JOptionPane.showMessageDialog(this, "La información del Libro es Inválida", "LIBRO NO VÁLIDO", JOptionPane.WARNING_MESSAGE);
            }   
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR AÑADIENDO EL LIBRO", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_addBookButtonActionPerformed

    /**
     * Remove the selected book on the Table.
     * @param evt (ActionEvent) When the Remove Button is pressed it activates.
     */
    private void deleteBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBookButtonActionPerformed
        // TODO add your handling code here:
        String remove_confirmation;
        String[] options = {"No", "Si"};
        int selected_option;
        
        try{
            if(libraryTable.getSelectedRow() != NOT_SELECTED_ROW){
            
                remove_confirmation = "¿Estás seguro que deseas eliminar el libro " + Library.getBook(libraryTable.getSelectedRow()).getTitle() + "?";
            
                selected_option = JOptionPane.showOptionDialog(this, remove_confirmation, "ELIMINAR LIBRO", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, "No");
            
            if(selected_option == 1){
                Library.deleteBook(libraryTable.getSelectedRow());
                updateTable();   
            }
            
            } else{
                JOptionPane.showMessageDialog(this, "Ninguna fila ha sido seleccionada", "ERROR: NINGUNA FILA SELECCIONADA", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR ELIMINANDO EL LIBRO", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_deleteBookButtonActionPerformed

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
                    Library.writeFile(path);
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
                    Library.readFile(path);
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
        try{
            if(libraryTable.getSelectedRow() != NOT_SELECTED_ROW){
                BookInformationWindow book_window = new BookInformationWindow(this, Library.getBook(libraryTable.getSelectedRow()));
                book_window.setVisible(true);
            } else{
                JOptionPane.showMessageDialog(this, "Ninguna fila ha sido seleccionada", "ERROR: NINGUNA FILA SELECCIONADA", JOptionPane.INFORMATION_MESSAGE);
            }   
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR: MOSTRANDO LA INFORMACION DEL LIBRO", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_buttonShowBookActionPerformed

    /**
     * When the window is closing it, the function disconnect to the Data Base that is connected.
     * @param evt Event to activate the function.
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            Library.disconnect();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR CERRANDO LA VENTANA", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_formWindowClosing
    
    /**
     * Button to edit the Information of an specified Book.
     * @param evt (Action Event) When the Button "Editat Libro" is pressed, activate.
     */
    private void editBookButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBookButton
        try{
            if(libraryTable.getSelectedRow() != NOT_SELECTED_ROW){
                EditBookWindow book_window = new EditBookWindow(this, Library.getBook(libraryTable.getSelectedRow()));
                book_window.setVisible(true);
            } else{
                JOptionPane.showMessageDialog(this, "Ninguna fila ha sido seleccionada", "ERROR: NINGUNA FILA SELECCIONADA", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR EDITANDO EL LIBRO", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_editBookButton

    /**
     * Set the order of the titles Ascendant.
     * @param evt (ActionEvent) User introduce the command or select the functionability on the menu bar.
     */
    private void menu_order_asc_titleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_order_asc_titleActionPerformed
        Library.setTitleAsc(true);
        Library.resetCurrentPage();
        this.updateTable();
    }//GEN-LAST:event_menu_order_asc_titleActionPerformed

    /**
     * Set the order of the titles Descendant.
     * @param evt (ActionEvent) User introduce the command or select the functionability on the menu bar.
     */
    private void menu_order_desc_titleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_order_desc_titleActionPerformed
        Library.setTitleAsc(false);
        Library.resetCurrentPage();
        this.updateTable();
    }//GEN-LAST:event_menu_order_desc_titleActionPerformed

    /**
     * Go to the previous page of the Library.
     * @param evt (ActionEvent) User introduce the command or select the functionability on the menu bar.
     */
    private void previous_page_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previous_page_menuActionPerformed
        Library.decreasePage();
        this.updateTable();
    }//GEN-LAST:event_previous_page_menuActionPerformed

    /**
     * Go to the next page of the Library.
     * @param evt (ActionEvent) User introduce the command or select the functionability on the menu bar.
     */
    private void next_page_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next_page_menuActionPerformed
        Library.increasePage();
        this.updateTable();
    }//GEN-LAST:event_next_page_menuActionPerformed

    /**
     * Go to the previous page of the Library.
     * @param evt (ActionEvent) User click the button previous on the screen.
     */
    private void button_prev_pageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_prev_pageActionPerformed
        Library.decreasePage();
        this.updateTable();
    }//GEN-LAST:event_button_prev_pageActionPerformed

    /**
     * Go to the next page of the Library.
     * @param evt (ActionEvent) User click the button next on the screen.
     */
    private void button_next_pageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_next_pageActionPerformed
        Library.increasePage();
        this.updateTable();
    }//GEN-LAST:event_button_next_pageActionPerformed

    /**
     * Find the Books depending on the Author.
     * @param evt (ActionEvent) When user clicks or press the command to find the author filter, it activates this function.
     */
    private void menu_author_filterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_author_filterActionPerformed
        FindAuthorWindow find_author = new FindAuthorWindow(this);
        find_author.setVisible(true);
    }//GEN-LAST:event_menu_author_filterActionPerformed

    /**
     * The fantasy genre is Selected and add to the Genres Filter the Fantasy Genre,
     *  instead, if the user is trying to unselect the Fantasy Genre, it will be removed from the Genres Filter List.
     * @param evt (ActionEvent) When user clicks or press the command to select the check button of fantasy on the menu,
     *  it activates this function.
     */
    private void menu_filter_fantasyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_filter_fantasyActionPerformed
        if(menu_filter_fantasy.isSelected()){
            Library.setGenresFilter(MainWindow.FANTASY_GENRE_ES);
        } else{
            Library.removeGenreFromFilter(MainWindow.FANTASY_GENRE_ES);
        }
        
        this.updateTable();
    }//GEN-LAST:event_menu_filter_fantasyActionPerformed

    /**
     * The Horro genre is Selected and add to the Genres Filter the Horror Genre,
     *  instead, if the user is trying to unselect the Horror Genre, it will be removed from the Genres Filter List.
     * @param evt (ActionEvent) When user clicks or press the command to select the check button of horror on the menu,
     *  it activates this function.
     */
    private void menu_filter_horrorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_filter_horrorActionPerformed
        if(menu_filter_horror.isSelected()){
            Library.setGenresFilter(MainWindow.HORROR_GENRE_ES);
        } else{
            Library.removeGenreFromFilter(MainWindow.HORROR_GENRE_ES);
        }
        
        this.updateTable();
    }//GEN-LAST:event_menu_filter_horrorActionPerformed

    /**
     * The comedy genre is Selected and add to the Genres Filter the Comedy Genre,
     *  instead, if the user is trying to unselect the Comedy Genre, it will be removed from the Genres Filter List.
     * @param evt (ActionEvent) When user clicks or press the command to select the check button of comedy on the menu,
     *  it activates this function.
     */
    private void menu_filter_comedyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_filter_comedyActionPerformed
        if(menu_filter_comedy.isSelected()){
            Library.setGenresFilter(MainWindow.COMEDY_GENRE_ES);
        } else{
            Library.removeGenreFromFilter(MainWindow.COMEDY_GENRE_ES);
        }
        
        this.updateTable();
    }//GEN-LAST:event_menu_filter_comedyActionPerformed

    /**
     * The romance genre is Selected and add to the Genres Filter the Romance Genres,
     *  instead, if the user is trying to unselect the Romance Genre, it will be removed from the Genres Filter List.
     * @param evt (ActionEvent) When user clicks or press the command to select the check button of romance on the menu,
     *  it activates this function.
     */
    private void menu_filter_romanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_filter_romanceActionPerformed
        if(menu_filter_romance.isSelected()){
            Library.setGenresFilter(MainWindow.ROMANCE_GENRE_ES);
        } else{
            Library.removeGenreFromFilter(MainWindow.ROMANCE_GENRE_ES);
        }
        this.updateTable();
    }//GEN-LAST:event_menu_filter_romanceActionPerformed

    /**
     * Clear all the Genres from the Genres Filter.
     * The CheckBox and the List.
     * @param evt (ActionEvent) When user clicks or press the command to select the radio button of rest on the menu,
     *  it activates this function.
     */
    private void reset_genres_filterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_genres_filterActionPerformed
        this.resetSelectedGenresFilter();
        Library.resetGenresFilter();
        this.updateTable();
    }//GEN-LAST:event_reset_genres_filterActionPerformed

    /**
     * Clear all the Filters from the Library.
     *  - Set the Current Page to the first one.
     *  - Set the Title Order alphabetical ascendand.
     *  - Set the author filter to empty.
     *  - Clear all the genres from the filter and clear the check boxes.
     *  - Clear the Age filter and the Radio Buttons.
     * @param evt (ActionEvent) User click or press the command to select the functionability.
     */
    private void menu_filter_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_filter_resetActionPerformed
        
        // SET THE CURRENT PAGE TO THE 1ST ONE (FIRST = 0).
        Library.setCurrentPage(0);
        
        // SET THE TITLE ORDER ASCENDAND.
        Library.setTitleAsc(true);
        
        // SET THE AUTHOR FILTER TO EMPTY TO SHOW ALL THE BOOKS INDEPENDANT OF THE AUTHOR.
        Library.setAuthorFilter("");
        
        // CLEAR ALL THE GENRES FROM THE FILTER.
        this.resetSelectedGenresFilter();
        Library.resetGenresFilter();
        
        // RESET THE AGE FILTER TO 0.
        Library.setAgeFilter("");
        age_filter_buttons.clearSelection();
        
        // UPDATE THE TABLE TO SHOW ALL THE BOOKS WITH THE FILTERS CLEARED.
        this.updateTable();
    }//GEN-LAST:event_menu_filter_resetActionPerformed

    /**
     * Select the Childish Age to add to the filter.
     * @param evt (ActionEvent) When user click the button on the menu or press the combination activated the function.
     */
    private void button_age_filter_infantilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_age_filter_infantilActionPerformed
        Library.setAgeFilter(CHILD_AGE_ES);
        this.updateTable();
    }//GEN-LAST:event_button_age_filter_infantilActionPerformed

    /**
     * Reset the age filter, and set the value to empty ("").
     * @param evt (ActionEvent) When user click the button on the menu or press the combination activated the function.
     */
    private void button_age_filter_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_age_filter_resetActionPerformed
        Library.setAgeFilter("");
        age_filter_buttons.clearSelection();
        this.updateTable();
    }//GEN-LAST:event_button_age_filter_resetActionPerformed

    /**
     * Select the Greater than Seven Age to add to the filter.
     * @param evt (ActionEvent) When user click the button on the menu or press the combination activated the function.
     */
    private void button_age_filter_sevenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_age_filter_sevenActionPerformed
        Library.setAgeFilter(SEVEN_AGE_ES);
        this.updateTable();
    }//GEN-LAST:event_button_age_filter_sevenActionPerformed

    /**
     * Select the Greater than Twelve Age to add to the filter.
     * @param evt (ActionEvent) When user click the button on the menu or press the combination activated the function.
     */
    private void button_age_filter_twelveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_age_filter_twelveActionPerformed
        Library.setAgeFilter(TWELVE_AGE_ES);
        this.updateTable();
    }//GEN-LAST:event_button_age_filter_twelveActionPerformed

    /**
     * Select the Adult Age to add to the filter.
     * @param evt (ActionEvent) When user click the button on the menu or press the combination activated the function.
     */
    private void button_age_filter_adultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_age_filter_adultActionPerformed
        Library.setAgeFilter(ADULT_AGE_ES);
        this.updateTable();
    }//GEN-LAST:event_button_age_filter_adultActionPerformed

    /**
     * Select the Childish Age to add to the filter.
     * @param evt (ActionEvent) When user click the button on the menu or press the combination activated the function.
     */
    private void menu_empty_libraryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_empty_libraryActionPerformed
        int selected_option;
        String remove_confirmation = "¿Seguro en eliminar la Libreria completa?";;
        String[] options = {"No", "Si"};
        
        try{
            selected_option = JOptionPane.showOptionDialog(this, remove_confirmation, "ELIMINAR LIBRO", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, "No");
            
            if(selected_option == 1){
                Library.deleteAll();
                this.updateTable();
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR VACIANDO LA LIBRERIA", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_menu_empty_libraryActionPerformed
    
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
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
    private javax.swing.ButtonGroup age_filter_buttons;
    private javax.swing.ButtonGroup author_asc_desc;
    private javax.swing.JTextField bookAuthorInput;
    private javax.swing.JLabel bookAuthorLabel;
    private javax.swing.JTextField bookTitleInput;
    private javax.swing.JLabel bookTitleLabel;
    private javax.swing.JButton buttonShowBook;
    private javax.swing.JRadioButtonMenuItem button_age_filter_adult;
    private javax.swing.JRadioButtonMenuItem button_age_filter_infantil;
    private javax.swing.JMenuItem button_age_filter_reset;
    private javax.swing.JRadioButtonMenuItem button_age_filter_seven;
    private javax.swing.JRadioButtonMenuItem button_age_filter_twelve;
    private javax.swing.JButton button_next_page;
    private javax.swing.JButton button_prev_page;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JPanel editorialLayout;
    private javax.swing.JComboBox<String> editorialOptions;
    private javax.swing.JCheckBox genreComedy;
    private javax.swing.JCheckBox genreFantasy;
    private javax.swing.JCheckBox genreHorror;
    private javax.swing.JCheckBox genreRomance;
    private javax.swing.JPanel genresPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAge;
    private javax.swing.JLabel labelEditorial;
    private javax.swing.JLabel labelGenres;
    private javax.swing.JLabel label_biblioteca;
    private javax.swing.JLabel label_page;
    private javax.swing.JPanel layoutAgeLiteraryType;
    private javax.swing.JPanel layoutButtons;
    private javax.swing.JTable libraryTable;
    private javax.swing.JPanel literaryPanel;
    private javax.swing.JMenuItem menuExportLibrary;
    private javax.swing.JMenu menuFiles;
    private javax.swing.JMenuItem menuImportLibrary;
    private javax.swing.JMenuItem menu_author_filter;
    private javax.swing.JMenu menu_current_page;
    private javax.swing.JMenuItem menu_empty_library;
    private javax.swing.JMenu menu_filter_age;
    private javax.swing.JCheckBoxMenuItem menu_filter_comedy;
    private javax.swing.JCheckBoxMenuItem menu_filter_fantasy;
    private javax.swing.JCheckBoxMenuItem menu_filter_horror;
    private javax.swing.JMenuItem menu_filter_reset;
    private javax.swing.JCheckBoxMenuItem menu_filter_romance;
    private javax.swing.JMenu menu_genres_filter;
    private javax.swing.JRadioButtonMenuItem menu_order_asc_title;
    private javax.swing.JRadioButtonMenuItem menu_order_desc_title;
    private javax.swing.JMenu menu_order_title;
    private javax.swing.JMenuItem next_page_menu;
    private javax.swing.JPanel northPanel;
    private javax.swing.JPanel panelsTitleAuthorInputs;
    private javax.swing.JMenuItem previous_page_menu;
    private javax.swing.JButton removeBookButton;
    private javax.swing.JMenuItem reset_genres_filter;
    private javax.swing.JPanel southPanel;
    // End of variables declaration//GEN-END:variables
}