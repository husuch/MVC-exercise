
/**
 * Die Klasse DataModel stellt eine Menge von Obejkten einer Datenklasse (hier DataClass) bereit.
 * Die Objekte sind typischwerweise in einer Collection abgelegt.
 * 
 * Für die Ausgabe werden die Werte der Daten-Objekte so aufbereitet, dass über den MVC-Mecano von Swing
 * eine JTable bedient wird.
 * Dazu muss diese Klasse das Interface TableModel implementieren. Das wird garantiert, in dem von 
 * DefaultTableModel (Komfortklasse) geerbt wird.
 * Um die Tabelle zu beschriften, werden in einem String-Array die Überschriften festgehalten.
 * 
 * @author René Probst
 *
 */
import java.util.*;

import javax.swing.table.*;

public class DataModel extends AbstractTableModel {

	// Hier die benötigten Attribute festlegen

	protected Vector<DataClass> dataVector;
	private String[] title;

	// Konstruktor
	public DataModel() {
		title = new String[] { "Marke", "Hubraum", "Leistung" };
		
		dataVector = new Vector<DataClass>();

		DataClass audi, bmw, mercedes, lada, toyota;
		audi = new DataClass("sAUDIarabische Motoren", (float) 2.967, 231);
		bmw = new DataClass("Beierische-Mist-Würste", (float) 4.662, 589);
		mercedes = new DataClass("SchiffAufRäder", (float) 4.506, 580);
		lada = new DataClass("Lade-Auf-Das-Auto", (float) 0.667, 90);
		toyota = new DataClass("Der Offroader Wagen", (float) 1.505, 150);

		dataVector.add(audi);
		dataVector.add(bmw);
		dataVector.add(mercedes);
		dataVector.add(lada);
		dataVector.add(toyota);

	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return title.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return dataVector.size();
	}

	public String getColumnName(int column) {

		return title[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		/*auch möglich mit:
		 * 
		 * if (columnIndex == 0) { return dataVector.get(rowIndex).getHersteller(); }
		 * else if (columnIndex == 1) { return dataVector.get(rowIndex).getHubraum(); }
		 * else { return dataVector.get(rowIndex).getLeistung(); }
		 */

		switch (columnIndex) {

		case 0:
			return dataVector.get(rowIndex).getHersteller();
		case 1:
			return dataVector.get(rowIndex).getHubraum();

		case 2:
			return dataVector.get(rowIndex).getLeistung();
			
		default: 
			return null;
		}

		

	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex == 0) {
			return false;
		} else {
			return true;
		}

	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		

		switch (columnIndex) {

		case 0:
			
			dataVector.get(rowIndex).setHersteller((String) aValue); break;

		case 1:
			dataVector.get(rowIndex).setHubraum(new Float((String)aValue).floatValue()); break;

		case 2:
			dataVector.get(rowIndex).setLeistung(new Integer((String)aValue).intValue()); break;
			
		default: 
			System.out.println("Felhler, ColumnIndex Falsch");
		}
		
		this.fireTableDataChanged();

	}

	public void addRow(DataClass obj) {

		dataVector.add(obj);
		this.fireTableDataChanged();
	}

	// und hier fügen Sie eine weitere Methdoe zu, die ein neues Objekt
	// der Klasse DataClass dem Vector zufügt und in der Tabelle zur
	// Anzeige bringt.

}
