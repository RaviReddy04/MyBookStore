
public class products {

	
	private String ASIN;
	private String ISBN;
	private String title;
	private String imageURL;
	private String publisher;
	private String publicationDate;
	private String price;
	private String productGroup;
	private String detailsURL;
	
	
	
	public products(String aSIN, String iSBN, String title, String imageURL, String publisher, String publicationDate,
			String price, String productGroup, String detailsURL) {
		super();
		this.ASIN = aSIN;
		this.ISBN = iSBN;
		this.title = title;
		this.imageURL = imageURL;
		this.publisher = publisher;
		this.publicationDate = publicationDate;
		this.price = price;
		this.productGroup = productGroup;
		this.detailsURL = detailsURL;
	}



	public products() {
		// TODO Auto-generated constructor stub
	}



	public String getASIN() {
		return ASIN;
	}



	public void setASIN(String aSIN) {
		ASIN = aSIN;
	}



	public String getISBN() {
		return ISBN;
	}



	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getImageURL() {
		return imageURL;
	}



	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}



	public String getPublisher() {
		return publisher;
	}



	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}



	public String getPublicationDate() {
		return publicationDate;
	}



	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}



	public String getPrice() {
		return price;
	}



	public void setPrice(String price) {
		this.price = price;
	}



	public String getProductGroup() {
		return productGroup;
	}



	public void setProductGroup(String productGroup) {
		this.productGroup = productGroup;
	}



	public String getDetailsURL() {
		return detailsURL;
	}



	public void setDetailsURL(String detailsURL) {
		this.detailsURL = detailsURL;
	}
	
	
	
	
	
	
}
