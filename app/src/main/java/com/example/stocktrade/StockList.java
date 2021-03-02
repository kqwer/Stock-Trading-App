    package com.example.stocktrade;

    public class StockList {
        private  String name;
        private String details;
        private  String ltp;
        private  String changeper;
        private  String changeprice;
    public StockList(){

    }
    public StockList(String name, String details, String ltp, String changeper, String changeprice) {
            this.details=details;
            this.name = name;
            this.ltp = ltp;
            this.changeper = changeper;
            this.changeprice = changeprice;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLtp() {
            return ltp;
        }

        public void setLtp(String ltp) {
            this.ltp = ltp;
        }

        public String getChangeper() {
            return changeper;
        }

        public void setChangeper(String changeper) {
            this.changeper = changeper;
        }

        public String getChangeprice() {
            return changeprice;
        }

        public void setChangeprice(String changeprice) {
            this.changeprice = changeprice;
        }


        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }
    }
