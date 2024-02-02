package com.microcare.nasscom_project.dto;

public class ProductDTO {

		

		private Integer productId;
		

		private String productName;
		

		private String description;
		

		private Double standardCost;
		

		private Double listPrice;
		
private Integer categoryId;

		public Integer getProductId() {
			return productId;
		}

		public void setProductId(Integer productId) {
			this.productId = productId;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Double getStandardCost() {
			return standardCost;
		}

		public void setStandardCost(Double standardCost) {
			this.standardCost = standardCost;
		}

		public Double getListPrice() {
			return listPrice;
		}

		public void setListPrice(Double listPrice) {
			this.listPrice = listPrice;
		}

		public Integer getCategoryId() {
			return categoryId;
		}

		public void setProductCategory(Integer categoryId) {
			this.categoryId = categoryId;
		}

		@Override
		public String toString() {
			return "Product [productId=" + productId + ", productName=" + productName + ", description=" + description
					+ ", standardCost=" + standardCost + ", listPrice=" + listPrice + ", categoryId=" + categoryId
					+ "]";
		}



}
