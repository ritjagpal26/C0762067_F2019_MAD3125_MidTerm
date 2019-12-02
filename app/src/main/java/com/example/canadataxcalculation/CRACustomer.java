package com.example.canadataxcalculation;

import android.os.Parcel;
import android.os.Parcelable;

public class CRACustomer implements Parcelable {

    public String fNAme;
    public String lName;
    public String dob;
    public int sinNumber;
    public double grossIncome;
    public double rrspCont;
    public   String gender;




       public CRACustomer()
       {

       }




    public CRACustomer(String fNAme, String lName, String dob, int sinNumber,double grossIncome, double rrspCont,String gender) {
        this.fNAme = fNAme;
        this.lName = lName;
        this.dob = dob;
        this.sinNumber = sinNumber;
        this.grossIncome = grossIncome;
        this.rrspCont = rrspCont;
        this.gender = gender;
//        this.total_taxable_amount = total_taxable_amount;
    }
      public String getGender() {
          return gender;
      }

      public void setGender(String gender) {
          this.gender = gender;
      }



    public String getfNAme() {
        return fNAme;
    }

    public void setfNAme(String fNAme) {
        this.fNAme = fNAme;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getSinNumber() {
        return sinNumber;
    }

    public void setSinNumber(int sinNumber) {
        this.sinNumber = sinNumber;
    }

    public double getGrossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(double grossIncome) {
        this.grossIncome = grossIncome;
    }

    public double getRrspCont() {
        return rrspCont;
    }

    public void setRrspCont(double rrspCont) {
        this.rrspCont = rrspCont;
    }

    public static Creator<CRACustomer> getCREATOR() {
        return CREATOR;
    }

    public double getTotal_taxable_amount() {
        return total_taxable_amount;
    }

    public void setTotal_taxable_amount(double total_taxable_amount) {
        this.total_taxable_amount = total_taxable_amount;
    }

    protected CRACustomer(Parcel in) {

        fNAme = in.readString();
        lName = in.readString();
        dob = in.readString();
        sinNumber = in.readInt();
        grossIncome = in.readDouble();
        rrspCont = in.readDouble();
        total_taxable_amount = in.readDouble();
    }

    public static final Creator<CRACustomer> CREATOR = new Creator<CRACustomer>() {
        @Override
        public CRACustomer createFromParcel(Parcel in) {
            return new CRACustomer(in);
        }

        @Override
        public CRACustomer[] newArray(int size) {
            return new CRACustomer[size];
        }
    };

    public String fullName() {

        String Fullname = lName.toUpperCase() + "," + fNAme.substring(0, 1).toUpperCase() + fNAme.substring(1).toLowerCase();
        return Fullname;
    }


    public float cppAmount() {

        System.out.println(gender);
        System.out.println("Print rrsp"+rrspCont);
        double cpp_max = 57400.00;
        double cpp_contribution_rate = 5.10;
        double total_cpp;
        if (grossIncome >= cpp_max) {
                        System.out.println("grossincpp "+grossIncome);

            total_cpp = (cpp_max * cpp_contribution_rate) / 100;
        } else {
            total_cpp = (grossIncome * cpp_contribution_rate) / 100;
                        System.out.println("grosselsecpp "+grossIncome);

        }
        System.out.println(total_cpp);
                return Float.valueOf((float) total_cpp);

    }

    public int calculateAge()
    {
        int age = 2019 - Integer.valueOf(dob);
        return  age;
    }


                public float EI(Double grossIncome) {
                double eIContribution = 0.00;
                System.out.println("in loop gi" + grossIncome);
                if (grossIncome >= 53100){
                    System.out.println("grossIfEI " + grossIncome);

                    eIContribution = 53100 * 0.0162;
                    System.out.println("ifEI " + eIContribution);
                    return Float.valueOf((float) eIContribution);

                } else{

                    eIContribution = grossIncome * 0.0162;
                    System.out.println("grossWElseEI " + grossIncome);

                    System.out.println("elseEI " + eIContribution);
                    return Float.valueOf((float) eIContribution);
                }


            }


    public float rrspAmount(Double grossIncome) {
        double rrsp_max;

        rrsp_max = (grossIncome * .18);
        if (rrsp_max > rrspCont) {
            double carry_forwaded_rrsp = rrsp_max - rrspCont;

            System.out.println("rrspcontcarry "+carry_forwaded_rrsp);
            return Float.valueOf((float)carry_forwaded_rrsp);
        }
             else {
            System.out.println("rrspcont "+rrspCont);
        return Float.valueOf((float)rrsp_max);         }

    }

    double total_taxable_amount = grossIncome ;



    public float federalTax() {


        Double FT = 0.00;
        Double temp =0.00;
//         double temp
         if(grossIncome <= 12096)
         {
             FT = FT * 0.00;
         }

        else if (grossIncome > 12096.01 && grossIncome <= 47630) {


            temp = grossIncome - 12069;
            FT = temp * .15;

        } else if (grossIncome > 47630.01 && grossIncome <= 95259) {

            temp = grossIncome - 47630;

            FT = temp * .205;

        } else if (grossIncome > 95259.01 && grossIncome <= 147667) {

            FT = FT + (grossIncome - 95259.01);
            FT = FT * .26;
//            return Double.valueOf((String.format("%.0f", FT)));

        } else if (grossIncome >= 147667.01 && grossIncome <= 210371) {

            FT = FT+(grossIncome - 147667.01);

            FT = FT * .0029;

        } else if (grossIncome >= 210371.01) {
            FT = FT+(grossIncome - 210371.01);

            FT = FT * .0033;
            }
        return Float.valueOf(String.valueOf(FT)) ;
    }

     public float provincTax() {

         System.out.println("pt gross"+ grossIncome);
         Double PT = 0.00;

          if(grossIncome <= 10582)
          {
              PT = PT * 0.00;
          }

         else if (grossIncome > 10582.01 && grossIncome <= 43906) {


             PT = grossIncome - 10582;
             PT = PT * .055;

         } else if (grossIncome > 43906.01 && grossIncome <= 87813) {

             PT = PT+(grossIncome - 43906);

             PT = PT * .0915;

         } else if (grossIncome > 87813.01 && grossIncome <= 150000.00) {

             PT = PT + (grossIncome - 87813.00);
             PT = PT * .1116;
         } else if (grossIncome >= 150000.01 && grossIncome <= 220000.00) {

             PT = PT+(grossIncome - 150000.00);

             PT = PT * .1216;

         } else if (grossIncome >= 220000.01) {
             PT = PT+(grossIncome - 220000.01);

             PT = PT * .1316;



         }
          return Float.valueOf(String.valueOf(PT));
     }

      float totaltaxammount = provincTax()+federalTax();

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fNAme);
        dest.writeString(lName);
        dest.writeString(dob);
        dest.writeInt(sinNumber);
        dest.writeDouble(grossIncome);
        dest.writeDouble(rrspCont);
        dest.writeDouble(total_taxable_amount);
    }
}























































































































































































































































































