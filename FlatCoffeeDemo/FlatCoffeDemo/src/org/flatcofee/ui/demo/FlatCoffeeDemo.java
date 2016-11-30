package org.flatcofee.ui.demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.flatcoffee.ui.button.FlatCoffeeRoundedButton;
import org.flatcoffee.ui.constants.FlatCoffeeColors;
import org.flatcoffee.ui.notification.FlatCoffeeNotificationPanel;
import java.awt.Insets;
import org.flatcoffee.ui.tagViewer.FlatCoffeeTagViewerPanel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import org.flatcoffee.ui.valueGauge.FlatCoffeeValueGaugePanel;
import org.flatcoffee.ui.comboBox.FlatCoffeeComboBox;
import javax.swing.DefaultComboBoxModel;

public class FlatCoffeeDemo extends JFrame {

	private JPanel contentPane;
	private FlatCoffeeTagViewerPanel tagViewerPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlatCoffeeDemo frame = new FlatCoffeeDemo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FlatCoffeeDemo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane); 
		
		FlatCoffeeNotificationPanel notificationPanel = new FlatCoffeeNotificationPanel();
		GridBagLayout gridBagLayout = (GridBagLayout) notificationPanel.getLayout();
		contentPane.add(notificationPanel, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 78, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		FlatCoffeeRoundedButton rndbtnRoundedButton = new FlatCoffeeRoundedButton("Rounded Button", FlatCoffeeColors.LIGHT_BLUE_INFO_COLOR );
		rndbtnRoundedButton.setText("Add to model");
		rndbtnRoundedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tagViewerPanel.getModel().addTag("Hello") ;
			}
		});
//		rndbtnRoundedButton.setEnabled(false);
		GridBagConstraints gbc_rndbtnRoundedButton = new GridBagConstraints();
		gbc_rndbtnRoundedButton.insets = new Insets(0, 0, 5, 5);
		gbc_rndbtnRoundedButton.gridx = 0;
		gbc_rndbtnRoundedButton.gridy = 0;
		panel.add(rndbtnRoundedButton, gbc_rndbtnRoundedButton);
		
		FlatCoffeeRoundedButton rndbtnRoundedbutton = new FlatCoffeeRoundedButton("RoundedButton2",  FlatCoffeeColors.LIGHT_RED_ALERT_COLOR );
		rndbtnRoundedbutton.setText("changeDefault");
		rndbtnRoundedbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tagViewerPanel.setDefaultTagName("new");
			}
		});
		GridBagConstraints gbc_rndbtnRoundedbutton = new GridBagConstraints();
		gbc_rndbtnRoundedbutton.insets = new Insets(0, 0, 5, 0);
		gbc_rndbtnRoundedbutton.gridx = 1;
		gbc_rndbtnRoundedbutton.gridy = 0;
		panel.add(rndbtnRoundedbutton, gbc_rndbtnRoundedbutton);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel.add(scrollPane, gbc_scrollPane);
		
		tagViewerPanel = new FlatCoffeeTagViewerPanel();
		scrollPane.setViewportView(tagViewerPanel);
		
		FlatCoffeeRoundedButton rndbtnClear = new FlatCoffeeRoundedButton((String) null, (Color) null);
		rndbtnClear.setBackground(Color.GREEN);
		rndbtnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tagViewerPanel.getModel().clearAll(); 
			}
		});
		rndbtnClear.setText("Clear from Model");
		GridBagConstraints gbc_rndbtnClear = new GridBagConstraints();
		gbc_rndbtnClear.insets = new Insets(0, 0, 5, 5);
		gbc_rndbtnClear.gridx = 0;
		gbc_rndbtnClear.gridy = 2;
		panel.add(rndbtnClear, gbc_rndbtnClear);
		
		JButton btnNewButton = new JButton("clear from tab panel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tagViewerPanel.removeAllTags();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 2;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		FlatCoffeeValueGaugePanel valueGauge = new FlatCoffeeValueGaugePanel();
		GridBagConstraints gbc_valueGauge = new GridBagConstraints();
		gbc_valueGauge.insets = new Insets(0, 0, 5, 0);
		gbc_valueGauge.gridwidth = 2;
		gbc_valueGauge.fill = GridBagConstraints.BOTH;
		gbc_valueGauge.gridx = 0;
		gbc_valueGauge.gridy = 4;
		panel.add(valueGauge, gbc_valueGauge);
		
		FlatCoffeeComboBox flatCoffeeComboBox = new FlatCoffeeComboBox();
		flatCoffeeComboBox.setModel(new DefaultComboBoxModel(new String[] {"1% cholesterol + 0.25% sodium cholate", "2,4-dinitrophenol", "2-nitrofluorene", "3-methylcholanthrene", "acarbose", "acetamide", "acetamidofluorene", "acetaminophen", "acetazolamide", "adapin", "aflatoxin B1", "ajmaline", "allopurinol", "allyl alcohol", "alpidem", "amiodarone", "amitriptyline", "amphotericin B", "aspirin", "azathioprine", "bendazac", "benzbromarone", "benziodarone", "bortezomib", "bromobenzene", "bromoethylamine", "bucetin", "buspirone", "buthionine sulfoximine", "butylated hydroxyanisole", "caffeine", "captopril", "carbamazepine", "carbon tetrachloride", "carboplatin", "cephalothin", "chloramphenicol", "chlormadinone", "chlormezanone", "chlorpheniramine", "chlorpromazine", "chlorpropamide", "cimetidine", "ciprofloxacin", "cisplatin", "clofibrate", "clomipramine", "clozapine", "colchicine", "compound_name", "coumarin", "cycloheximide", "cyclophosphamide", "cyclosporine A", "danazol", "dantrolene", "desmopressin acetate", "dexamethasone", "diazepam", "diclofenac", "diethyl maleate", "diltiazem", "disopyramide", "disulfiram", "doxorubicin", "enalapril", "erythromycin ethylsuccinate", "ethambutol", "ethanol", "ethinylestradiol", "ethionamide", "ethionine", "etoposide", "famotidine", "fenofibrate", "fluoxetine hydrochloride", "fluphenazine", "flutamide", "furosemide", "galactosamine", "gefitinib", "gemfibrozil", "gentamicin", "glibenclamide", "griseofulvin", "haloperidol", "hepatocyte growth factor, human", "hexachlorobenzene", "hydroxyzine", "ibuprofen", "imatinib, methanesulfonate salt", "imipramine", "indomethacin", "interferon alpha, human", "interleukin 1 beta, human", "interleukin 6, human", "iproniazid", "isoniazid", "ketoconazole", "labetalol", "lomustine", "lornoxicam", "LPS", "mefenamic acid", "meloxicam", "metformin", "methapyrilene", "methimazole", "methyldopa", "methylene dianiline", "methyltestosterone", "mexiletine", "monocrotaline", "moxisylyte", "naphthyl isothiocyanate", "naproxen", "nefazodone", "nicotinic acid", "nifedipine", "nimesulide", "nitrofurantoin", "nitrofurazone", "nitrosodiethylamine", "N-methyl-N-nitrosourea", "N-nitrosomorpholine", "omeprazole", "papaverine", "pemoline", "penicillamine", "perhexiline", "phalloidin", "phenacetin", "phenobarbital", "phenylanthranilic acid", "phenylbutazone", "phenytoin", "phorone", "promethazine", "propranolol", "propylthiouracil", "puromycin aminonucleoside", "quinidine", "ranitidine", "rifampicin", "rosiglitazone maleate", "rotenone", "simvastatin", "sulfasalazine", "sulindac", "sulpiride", "tacrine", "tamoxifen", "tannic acid", "terbinafine", "tetracycline", "theophylline", "thioacetamide", "thioridazine", "ticlopidine", "tiopronin", "TNFalpha", "tolbutamide", "transforming growth factor beta 1", "triamterene", "triazolam", "trimethadione", "tunicamycin", "valproic acid", "venlafaxine", "vitamin A", "WY-14643"}));
		GridBagConstraints gbc_flatCoffeeComboBox = new GridBagConstraints();
		gbc_flatCoffeeComboBox.insets = new Insets(0, 0, 0, 5);
		gbc_flatCoffeeComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_flatCoffeeComboBox.gridx = 0;
		gbc_flatCoffeeComboBox.gridy = 6;
		panel.add(flatCoffeeComboBox, gbc_flatCoffeeComboBox);
	}

}
