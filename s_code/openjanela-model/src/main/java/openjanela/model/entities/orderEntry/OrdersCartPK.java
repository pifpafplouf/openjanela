package openjanela.model.entities.orderEntry;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Sherif
 */
@Embeddable
public class OrdersCartPK implements Serializable {

	@Column(name = "id", nullable = false)
	private int id;
	@Column(name = "type", nullable = false)
	private int type;
	@Column(name = "prefix", nullable = false)
	private String prefix;
	@Column(name = "order_no", nullable = false)
	private int orderNo;
	@Column(name = "version", nullable = false)
	private int version;
	
	public OrdersCartPK() {}
	
	public OrdersCartPK(int id, int type, String prefix, int orderNo, int version) {
		this.id = id;
		this.type = type;
		this.prefix = prefix;
		this.orderNo = orderNo;
		this.version = version;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public String getPrefix() {
		return prefix;
	}
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	public int getOrderNo() {
		return orderNo;
	}
	
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	
	public int getVersion() {
		return version;
	}
	
	public void setVersion(int version) {
		this.version = version;
	}
	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += id;
		hash += type;
		hash += (prefix != null ? prefix.hashCode() : 0);
		hash += orderNo;
		hash += version;
		return hash;
	}
	
	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof OrdersCartPK)) {
			return false;
		}
	OrdersCartPK other = (OrdersCartPK) object;
	if (this.id != other.id) {
		return false;
	}
	if (this.type != other.type) {
		return false;
	}
	if ((this.prefix == null && other.prefix != null) || (this.prefix != null && !this.prefix.equals(other.prefix))) {
		return false;
	}
	if (this.orderNo != other.orderNo) {
		return false;
	}
	if (this.version != other.version) {
		return false;
	}
	return true;
	}
	
	@Override
	public String toString() {
		return "Openjanela_Partner_PersistenceObjects.OrdersCartPK[ id=" + id + ", type=" + type + ", prefix=" + prefix + ", orderNo=" + orderNo + ", version=" + version + " ]";
	}
	
}
