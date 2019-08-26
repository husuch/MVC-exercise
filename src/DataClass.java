/**
 * @author  Nicolas Hauser
 * @date    26.10.218
 * @version 1.0
 *
 */
public class DataClass {
	// die Attribute des Datenobjekts
	private String    hersteller;
	private float     hubraum;
	private int       leistung;
	
	/** 
	 * Leerer Konstrukter für ein Objekt der Daten-Klasse
	 */
	public DataClass(){
	}
	
	/**
	 * Parametrierter Konstruktor der Data-Klasse
	 */
	public DataClass(String hersteller, float hubraum, int leistung){
		this.hersteller = hersteller;
		this.hubraum    = hubraum;
		this.leistung   = leistung;
	}
	
	public void setHersteller(String hersteller){
		this.hersteller = hersteller;
	}
	
	public void setHubraum(float hubraum){
		this.hubraum = hubraum;
	}
	
	public void setLeistung(int leistung){
		this.leistung = leistung;
	}
	
	public String getHersteller(){
		return this.hersteller;
	}
	
	public float getHubraum(){
		return this.hubraum;
	}
	
	public int getLeistung(){
		return this.leistung;
	}
}
