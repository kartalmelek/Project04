package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class SpendinggoodPage {

    public SpendinggoodPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Ortak locate'ler
    @FindBy(xpath="(//*[@class='w-icon-account'])[1]")
    public WebElement signIn;
    @FindBy(id="username")
    public WebElement userName;
    @FindBy(id="password")
    public WebElement passWord;
    @FindBy(xpath="//*[@value='Sign In']")
    public WebElement submit;
    @FindBy(xpath="//li[@id='menu-item-1074']")
    public WebElement myAccount;
    @FindBy(xpath="//a[text()='Store Manager']")
    public WebElement storeManager;






















    //Us 01-02 Ertugrul (50-99)

















































    //US 03-04-21 Yusuf (100-179)
    @FindBy(xpath = "//*[@name='login']")
    public WebElement login2;
    @FindBy(xpath = "(//*[@class='text'])[14]")
    public WebElement reports;
    @FindBy(xpath = "//*[text()='Year']")
    public WebElement year;
    @FindBy(xpath = "//*[text()='Last Month']")
    public WebElement lastmonth;
    @FindBy(xpath = "//*[text()='This Month']")
    public WebElement thismonth;
    @FindBy(xpath = "//*[text()='Last 7 Days']")
    public WebElement last7days;
    @FindBy(xpath = "//*[@class='wcfm-date-range']")
    public WebElement custom;
    @FindBy(xpath = "//*[text()='Orders']")
    public WebElement orders;
    @FindBy(xpath = "//*[text()='Go Shop']")
    public WebElement gotoshop;
    @FindBy(xpath = "(//*[@class='product-media'])[1]")
    public WebElement urun1;
    @FindBy(xpath = "//*[@name='add-to-cart']")
    public WebElement urunadd;
    @FindBy(xpath = "(//*[@class='product-media'])[4]")
    public WebElement urun2;
    @FindBy(xpath = "(//*[@class='product-media'])[5]")
    public WebElement urun3;
    @FindBy(xpath = "(//*[@class='product-media'])[6]")
    public WebElement urun4;
    @FindBy(xpath = "(//*[@class='product-media'])[7]")
    public WebElement urun5;
    @FindBy(xpath = "//*[@class='cart-toggle']")
    public WebElement sepet;
    @FindBy(xpath = "//*[text()='A Deneme']")
    public List<WebElement> sepet1;
    @FindBy(xpath = "//*[text()='View cart']")
    public WebElement viewcart;
    @FindBy(xpath = "//*[@class='checkout-button button alt wc-forward']")
    public WebElement proceedtocheckout;
    @FindBy(xpath = "//*[text()='Billing details']")
    public WebElement billingdetails;
    @FindBy(xpath = "(//*[@class='input-text '])[1]")
    public WebElement name;
    @FindBy(xpath = "(//*[@class='select2-selection__rendered'])[1]")
    public WebElement selectcountry;
    @FindBy(xpath = "//*[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received order-success']")
    public WebElement thankyouyazisi;
    @FindBy(xpath = "(//*[@class='woocommerce-Price-amount amount'])[4]")
    public WebElement sepetsayim;
    @FindBy(xpath = "//*[@title='Plus']")
    public WebElement urunarttirma;
    @FindBy(xpath = "//*[@name='update_cart']")
    public WebElement update;
    @FindBy(xpath = "//*[@title='Minus']")
    public WebElement urunazaltma;
    @FindBy(xpath = "//*[@class='stock in-stock']")
    public WebElement stocksayisi;
    @FindBy(xpath = "//*[@type='number']")
    public WebElement stockguncelleme;
    @FindBy(xpath = "//*[@name='clear_cart']")
    public WebElement clearcart;
    @FindBy(xpath = "//*[text()='Your cart is currently empty.']")
    public WebElement sepetbosyazisi;
    @FindBy(xpath = "//*[@name='apply_coupon']")
    public WebElement cuponsecenegi;
    @FindBy(xpath = "//*[text()='Continue Shopping']")
    public WebElement continoushopping;
    @FindBy(xpath="//*[text()='Total']")
    public WebElement totalamount;
    @FindBy(xpath = "(//*[text()='1,100.00'])[2]")
    public WebElement toplam;







    //Us 05-06-07 Mustafa (180-229)

















































    //US 08-09-10 Nevcan (230-279)

















































    //US 11-12 - Mine (280-349)





































































    //US 13-14-15 Melek (350-399)

















































    //US 16-17-18 HAKAN (400-449)

















































    //US 19-20-22 ASIM (450-499)
    @FindBy (xpath = "//span[@class='wcfmfa fa-child']")
    public WebElement followersButton;
    @FindBy (className = "dataTables_empty")
    public WebElement emptyTable;
    @FindBy(xpath="//*[@class='wcfm_menu_items wcfm_menu_wcfm-products']")
    public WebElement productsButton;
    @FindBy (xpath = "//tbody//tr//td[3]")
    public WebElement ilkUrun;
    @FindBy (xpath = "//input[@class='wcfm_submit_button' and @value='View']")
    public WebElement viewButton;
    @FindBy (xpath = "//a[@href='#tab-reviews']")
    public WebElement customerReviewsButton;
    @FindBy (className = "comment-text")
    public WebElement commentText;
    @FindBy (xpath = "//header[@class='header custom-header header-11']")
    public WebElement emptyHeader;
    @FindBy (xpath = "//a[@href='/shop/?orderby=popularity&deals=1']")
    public WebElement dailyDeals;
    @FindBy (className = "toolbox-left")
    public WebElement sortBy;
    @FindBy (xpath = "//select[@name='orderby']//option")
    public WebElement sortByDropDown;
    @FindBy (xpath = "//div//figure")
    public List<WebElement> dusukFiyatSiralamasi;











}
