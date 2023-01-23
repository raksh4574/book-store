 package com.pj.dto;//data transferring object

public class Book {
		private int id;
		private String name;
		private String auther;
		private int page;
		private double price;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAuther() {
			return auther;
		}
		public void setAuther(String auther) {
			this.auther = auther;
		}
		public int getPage() {
			return page;
		}
		public void setPage(int page) {
			this.page = page;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		@Override
		public String toString() {
			return "Book [id=" + id + ", name=" + name + ", auther=" + auther + ", page=" + page + ", price=" + price
					+ "]";
		}
		
		
		

}
