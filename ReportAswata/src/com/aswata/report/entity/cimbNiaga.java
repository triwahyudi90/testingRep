/**
 * 
 */
package com.aswata.report.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Tri Wahyudi
 *
 */
public class cimbNiaga {
	private String Periode;
	private String policyNumber;
	private String busreq;
	private String namaTertanggung;
	private String qqName;
	private String cabang;
	private String kota;
	private String sumberBisnis;
	private String segment;
	private String jenisPertanggungan;
	private BigDecimal premiGross;
	private BigDecimal komisi;
	private BigDecimal komisiBank;
	private BigDecimal diskon;
	private String StatusPolis;
	private String obyekAsuransi;
	private String curr;
	private BigDecimal nilaiPertanggungan;
	private String lokasiPertanggungan;
	private String tglEfektif;
	private String tglJatuhTempo;
	private String keterangan;
	private String noRangka;
	private String noMesin;
	private String StatusAsuransi;
	private BigDecimal ppn;
	private String tglTerbitPolis;
	private String transactionDate;
	/**
	 * @return the periode
	 */
	public String getPeriode() {
		return Periode;
	}
	/**
	 * @return the transactionDate
	 */
	public String getTransactionDate() {
		return transactionDate;
	}
	/**
	 * @param transactionDate the transactionDate to set
	 */
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	/**
	 * @param periode the periode to set
	 */
	public void setPeriode(String periode) {
		Periode = periode;
	}
	/**
	 * @return the policyNumber
	 */
	public String getPolicyNumber() {
		return policyNumber;
	}
	/**
	 * @param policyNumber the policyNumber to set
	 */
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	/**
	 * @return the busreq
	 */
	public String getBusreq() {
		return busreq;
	}
	/**
	 * @param busreq the busreq to set
	 */
	public void setBusreq(String busreq) {
		this.busreq = busreq;
	}
	/**
	 * @return the namaTertanggung
	 */
	public String getNamaTertanggung() {
		return namaTertanggung;
	}
	/**
	 * @param namaTertanggung the namaTertanggung to set
	 */
	public void setNamaTertanggung(String namaTertanggung) {
		this.namaTertanggung = namaTertanggung;
	}
	/**
	 * @return the qqName
	 */
	public String getQqName() {
		return qqName;
	}
	/**
	 * @param qqName the qqName to set
	 */
	public void setQqName(String qqName) {
		this.qqName = qqName;
	}
	/**
	 * @return the cabang
	 */
	public String getCabang() {
		return cabang;
	}
	/**
	 * @param cabang the cabang to set
	 */
	public void setCabang(String cabang) {
		this.cabang = cabang;
	}
	/**
	 * @return the kota
	 */
	public String getKota() {
		return kota;
	}
	/**
	 * @param kota the kota to set
	 */
	public void setKota(String kota) {
		this.kota = kota;
	}
	/**
	 * @return the sumberBisnis
	 */
	public String getSumberBisnis() {
		return sumberBisnis;
	}
	/**
	 * @param sumberBisnis the sumberBisnis to set
	 */
	public void setSumberBisnis(String sumberBisnis) {
		this.sumberBisnis = sumberBisnis;
	}
	/**
	 * @return the segment
	 */
	public String getSegment() {
		return segment;
	}
	/**
	 * @param segment the segment to set
	 */
	public void setSegment(String segment) {
		this.segment = segment;
	}
	/**
	 * @return the jenisPertanggungan
	 */
	public String getJenisPertanggungan() {
		return jenisPertanggungan;
	}
	/**
	 * @param jenisPertanggungan the jenisPertanggungan to set
	 */
	public void setJenisPertanggungan(String jenisPertanggungan) {
		this.jenisPertanggungan = jenisPertanggungan;
	}
	/**
	 * @return the premiGross
	 */
	public BigDecimal getPremiGross() {
		return premiGross;
	}
	/**
	 * @param premiGross the premiGross to set
	 */
	public void setPremiGross(BigDecimal premiGross) {
		this.premiGross = premiGross;
	}
	/**
	 * @return the komisi
	 */
	public BigDecimal getKomisi() {
		return komisi;
	}
	/**
	 * @param komisi the komisi to set
	 */
	public void setKomisi(BigDecimal komisi) {
		this.komisi = komisi;
	}
	/**
	 * @return the komisiBank
	 */
	public BigDecimal getKomisiBank() {
		return komisiBank;
	}
	/**
	 * @param komisiBank the komisiBank to set
	 */
	public void setKomisiBank(BigDecimal komisiBank) {
		this.komisiBank = komisiBank;
	}
	/**
	 * @return the diskon
	 */
	public BigDecimal getDiskon() {
		return diskon;
	}
	/**
	 * @param diskon the diskon to set
	 */
	public void setDiskon(BigDecimal diskon) {
		this.diskon = diskon;
	}
	/**
	 * @return the statusPolis
	 */
	public String getStatusPolis() {
		return StatusPolis;
	}
	/**
	 * @param statusPolis the statusPolis to set
	 */
	public void setStatusPolis(String statusPolis) {
		StatusPolis = statusPolis;
	}
	/**
	 * @return the obyekAsuransi
	 */
	public String getObyekAsuransi() {
		return obyekAsuransi;
	}
	/**
	 * @param obyekAsuransi the obyekAsuransi to set
	 */
	public void setObyekAsuransi(String obyekAsuransi) {
		this.obyekAsuransi = obyekAsuransi;
	}
	/**
	 * @return the curr
	 */
	public String getCurr() {
		return curr;
	}
	/**
	 * @param curr the curr to set
	 */
	public void setCurr(String curr) {
		this.curr = curr;
	}
	/**
	 * @return the nilaiPertanggungan
	 */
	public BigDecimal getNilaiPertanggungan() {
		return nilaiPertanggungan;
	}
	/**
	 * @param nilaiPertanggungan the nilaiPertanggungan to set
	 */
	public void setNilaiPertanggungan(BigDecimal nilaiPertanggungan) {
		this.nilaiPertanggungan = nilaiPertanggungan;
	}
	/**
	 * @return the lokasiPertanggungan
	 */
	public String getLokasiPertanggungan() {
		return lokasiPertanggungan;
	}
	/**
	 * @param lokasiPertanggungan the lokasiPertanggungan to set
	 */
	public void setLokasiPertanggungan(String lokasiPertanggungan) {
		this.lokasiPertanggungan = lokasiPertanggungan;
	}
	/**
	 * @return the tglEfektif
	 */
	public String getTglEfektif() {
		return tglEfektif;
	}
	/**
	 * @param tglEfektif the tglEfektif to set
	 */
	public void setTglEfektif(String tglEfektif) {
		this.tglEfektif = tglEfektif;
	}
	/**
	 * @return the tglJatuhTempo
	 */
	public String getTglJatuhTempo() {
		return tglJatuhTempo;
	}
	/**
	 * @param tglJatuhTempo the tglJatuhTempo to set
	 */
	public void setTglJatuhTempo(String tglJatuhTempo) {
		this.tglJatuhTempo = tglJatuhTempo;
	}
	/**
	 * @return the keterangan
	 */
	public String getKeterangan() {
		return keterangan;
	}
	/**
	 * @param keterangan the keterangan to set
	 */
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
	/**
	 * @return the noRangka
	 */
	public String getNoRangka() {
		return noRangka;
	}
	/**
	 * @param noRangka the noRangka to set
	 */
	public void setNoRangka(String noRangka) {
		this.noRangka = noRangka;
	}
	/**
	 * @return the noMesin
	 */
	public String getNoMesin() {
		return noMesin;
	}
	/**
	 * @param noMesin the noMesin to set
	 */
	public void setNoMesin(String noMesin) {
		this.noMesin = noMesin;
	}
	/**
	 * @return the statusAsuransi
	 */
	public String getStatusAsuransi() {
		return StatusAsuransi;
	}
	/**
	 * @param statusAsuransi the statusAsuransi to set
	 */
	public void setStatusAsuransi(String statusAsuransi) {
		StatusAsuransi = statusAsuransi;
	}
	/**
	 * @return the ppn
	 */
	public BigDecimal getPpn() {
		return ppn;
	}
	/**
	 * @param ppn the ppn to set
	 */
	public void setPpn(BigDecimal ppn) {
		this.ppn = ppn;
	}
	/**
	 * @return the tglTerbitPolis
	 */
	public String getTglTerbitPolis() {
		return tglTerbitPolis;
	}
	/**
	 * @param tglTerbitPolis the tglTerbitPolis to set
	 */
	public void setTglTerbitPolis(String tglTerbitPolis) {
		this.tglTerbitPolis = tglTerbitPolis;
	}
	
	
}
