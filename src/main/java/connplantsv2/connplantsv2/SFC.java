package connplantsv2.connplantsv2;

public class SFC {
	
	public String site;
	public String shoporder;
	public String sfc;
	public String qty;
	public String qty_done;
	public String qty_scrapped;
	public String status;
	public String modified_dt;
	
	public SFC() {}
	
	public SFC(String site, String shoporder, String sfc, String qty, String qty_done, String qty_scrapped,
			String status, String modified_dt) {
		super();
		this.site = site;
		this.shoporder = shoporder;
		this.sfc = sfc;
		this.qty = qty;
		this.qty_done = qty_done;
		this.qty_scrapped = qty_scrapped;
		this.status = status;
		this.modified_dt = modified_dt;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getShoporder() {
		return shoporder;
	}
	public void setShoporder(String shoporder) {
		this.shoporder = shoporder;
	}
	public String getSfc() {
		return sfc;
	}
	public void setSfc(String sfc) {
		this.sfc = sfc;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public String getQty_done() {
		return qty_done;
	}
	public void setQty_done(String qty_done) {
		this.qty_done = qty_done;
	}
	public String getQty_scrapped() {
		return qty_scrapped;
	}
	public void setQty_scrapped(String qty_scrapped) {
		this.qty_scrapped = qty_scrapped;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getModified_dt() {
		return modified_dt;
	}
	public void setModified_dt(String modified_dt) {
		this.modified_dt = modified_dt;
	}
	
	

}
