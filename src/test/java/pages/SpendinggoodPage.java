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
    @FindBy(xpath="//*[@class='wcfm_menu_items wcfm_menu_wcfm-products']")
    public WebElement products;
    @FindBy(xpath="//*[@class='sorting_disabled']")
    public List<WebElement> producListMenu;
    @FindBy(xpath="//*[@id='add_new_product_dashboard']")
    public WebElement addNewButton;
    @FindBy(xpath="//input[@id='is_virtual']")
    public WebElement virtualText;
    @FindBy(xpath="//input[@id='is_downloadable']")
    public WebElement dawnlodableText;
    @FindBy(xpath="//*[@id='pro_title']")
    public WebElement productTitle;
    @FindBy(xpath="//*[@id='gallery_img_gimage_0_display']")
    public WebElement productPhoto;
    @FindBy(xpath="//*[@id='menu-item-browse']")
    public WebElement mediaGalery;
    @FindBy(xpath="//li[@role='checkbox']")
    public WebElement photos;
    @FindBy(xpath="(//*[text()='Add to Gallery'])[3]")
    public WebElement addToGalery;
    @FindBy(xpath="//div//strong[text()='Short Description']")
    public WebElement shortDescription;
    @FindBy(xpath="//div//strong[text()='Description']")
    public WebElement description;
    @FindBy(xpath="//input[@id='manage_stock']")
    public WebElement manageStockClick;
    @FindBy(xpath="//*[@id='wcfm_products_simple_submit_button']")
    public WebElement submitAddProduct;
    @FindBy(xpath="//li/input[@value='229']")
    public WebElement accessoriesCategories;
    @FindBy(xpath="//li/input[@value='232']")
    public WebElement bookmusicFilmCategories;
    @FindBy(xpath="//li/input[@value='230']")
    public WebElement electronicCategories;
    @FindBy(xpath="//li/input[@value='235']")
    public WebElement healthBeautyCategories;
    @FindBy(xpath="//li/input[@value='350']")
    public WebElement giftIdeasCategories;
    @FindBy(xpath="//li/input[@value='344']")
    public WebElement fashionCategories;
    @FindBy(xpath="//li/input[@value='448']")
    public WebElement cosmeticCategories;
    @FindBy(xpath="//li/input[@value='345']")
    public WebElement foodCategories;
    @FindBy(xpath="//li/input[@value='353']")
    public WebElement kidsCategories;
    @FindBy(xpath="//li/input[@value='352']")
    public WebElement menCategories;

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

























    // mustafa 500-550
    @FindBy(xpath="//li/input[@value='351']")
    public WebElement womenCategories;
    @FindBy(xpath="//li/input[@value='35']")
    public WebElement elegantAutoGroupBrand;
    @FindBy(xpath="//li/input[@value='41']")
    public WebElement greenGrassBrand;
    @FindBy(xpath="//li/input[@value='46']")
    public WebElement nodeJsBrand;
    @FindBy(xpath="//li/input[@value='47']")
    public WebElement NSBBrand;
    @FindBy(xpath="//li/input[@value='50']")
    public WebElement REDBrand;
    @FindBy(xpath="//li/input[@value='52']")
    public WebElement skySuiteTechBrand;
    @FindBy(xpath="//li/input[@value='55']")
    public WebElement sterlingBrand;





































}
