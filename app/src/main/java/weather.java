import java.text.NumberFormat;

public class weather
{
    public String dayOfWeek;
 public String minTemp;
 public String maxTemp;
 public String humidity;
 public String description;
 public String iconURL;
    public void Weather(long timeStamp, double minTemp, double maxTemp,
                        double humidity, String description, String iconName) {
         // NumberFormat to format double temperatures rounded to integers
         NumberFormat numberFormat = NumberFormat.getInstance();
         numberFormat.setMaximumFractionDigits(0);
         this.dayOfWeek = convertTimeStampToDay(timeStamp);
        this.minTemp = numberFormat.format(minTemp) +"\u00B0F" ;
        this.maxTemp = numberFormat.format(maxTemp) + "\u00B0F";
        this.humidity = NumberFormat.getPercentInstance().format(humidity / 100.0);
         this.description = description;
        this.iconURL =
                "http://openweathermap.org/img/w/" + iconName + ".png";
    }

    private String convertTimeStampToDay(long timeStamp) {
        return null;
    }

    public weather(String dayOfWeek, String minTemp, String maxTemp, String humidity, String description, String iconURL) {
        this.dayOfWeek = dayOfWeek;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.humidity = humidity;
        this.description = description;
        this.iconURL = iconURL;
    }
}
