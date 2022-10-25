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

















    //Us 01-02 Ertugrul (47-99)
    @FindBy(xpath = "//*[text()='Register']")
    public WebElement Register;
    @FindBy(xpath = "//*[@class='nav-link']")
    public WebElement SIGNUP;
    @FindBy(xpath = "//*[@class='wcfmmp_become_vendor_link']")
    public WebElement BecomeVendor;
    @FindBy(xpath = "//*[@class='page-title']")
    public WebElement VendorRegistration;
    @FindBy(xpath = "//*[@id='wcfm_membership_registration_form']")
    public WebElement EmailPasswordConfirmPassword;
    @FindBy(xpath = "//*[@class='wcfm-membership-wrapper']")
    public WebElement UcEmailPasswordConfirmPassword;
    @FindBy(xpath = "//*[@id='user_email']")
    public WebElement Email1;
    @FindBy(xpath = "//*[@class='wcfm-text wcfm_email_verified_input']")
    public WebElement VerificationCodeBox;
    @FindBy(xpath = "//*[@class='wcfm-text wcfm_submit_button wcfm_email_verified_button']")
    public WebElement ReSendCode;
    @FindBy(xpath = "//*[@id='passoword']")
    public WebElement Password;
    @FindBy(xpath = "//*[@id='confirm_pwd']")
    public WebElement ConfirmPassword;
    @FindBy(xpath = "//*[@id='wcfm_membership_register_button']")
    public WebElement RegisterButton;
    @FindBy(xpath = "//*[@class='wcfm-message wcfm-error']")
    public WebElement UniqOlmayanYazisi;
    @FindBy(xpath = "//*[@id='menu-item-1074']")
    public WebElement MyAccount;
    @FindBy(xpath = "//*[@class='email']")
    public WebElement geciciEmail;
    @FindBy(css = "a#renew")
    public WebElement emailBoxRefresh;
    @FindBy(xpath = "//tbody//tr[1]")
    public WebElement geciciEmailBox;
    @FindBy(xpath = "//*[@id='body_content_inner']")
    public WebElement verificationCode;
    @FindBy(xpath = "//*[@id='renew']")
    public WebElement yenilemeTusu;
    @FindBy(xpath = "//*[@class='page-title']")
    public WebElement MyAccountYazisi;
    @FindBy(xpath = "//*[@id='username']")
    public WebElement UserName;
    @FindBy(xpath = "//*[@id='password']")
    public WebElement PasswordSignIn;
    @FindBy(xpath = "//*[@value='Sign In']")
    public WebElement SignInButton;
    @FindBy(xpath = "//*[text()='Log out']")
    public WebElement LogOut;
    @FindBy(xpath = "//*[@class='text-uppercase text-center mb-0']")
    public List<WebElement> Elemanlar;


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
    @FindBy (xpath = "(//span[@class='wcfmfa fa-edit text_tip'])[5]")
    public WebElement nikeTshirtEdit;

    @FindBy (xpath = "//*[@id='manage_stock']")
    public WebElement manageStockCheckBox;

    @FindBy (xpath = "//*[@id='stock_qty']")
    public WebElement stockQty;

    @FindBy (xpath = "(//input[@class='wcfm_submit_button'])[1]")
    public WebElement submitButton;

    @FindBy (xpath = "(//*[@id='backorders'])[6]")
    public WebElement backordersDropdown;

    @FindBy (xpath = "//*[text()='Product Successfully Published.']")
    public WebElement successfullyPublished;

    @FindBy (xpath = "(//*[@class='page_collapsible_content_holder'])[4]")
    public WebElement shippingButton;

    @FindBy (xpath = "(//*[@class='wcfm-text wcfm_ele simple variable booking'])[1]")
    public WebElement weight;

    @FindBy (xpath = "(//*[@id='_wcfmmp_processing_time'])[3]")
    public WebElement processTimeDropdown;

    @FindBy (xpath = "(//*[@class='page_collapsible_content_holder'])[5]")
    public WebElement attributesButton;

    @FindBy (id = "attributes_is_active_1")
    public WebElement colorCheckBox;

    @FindBy (xpath = "(//*[@class='button wcfm_add_attribute_term wcfm_select_all_attributes'])[1]")
    public WebElement colorSelectAll;

    @FindBy (id = "attributes_is_active_2")
    public WebElement sizeCheckBox;

    @FindBy (xpath = "(//*[@class='button wcfm_add_attribute_term wcfm_select_all_attributes'])[2]")
    public WebElement sizeSelectAll;








    //US 11-12 - Mine (280-349)
    @FindBy(xpath = "(//*[@class='w-icon-account'])[1]")
    public WebElement signButton;
    @FindBy(xpath ="(//*[@class='w-icon-account'])[1]")
    public WebElement singout;
    @FindBy(xpath ="(//*[@class='woocommerce-Input woocommerce-Input--text input-text'])[1]")
    public WebElement userrEmail;
    @FindBy(xpath ="(//*[@class='woocommerce-Input woocommerce-Input--text input-text'])[2]")
    public WebElement password;
    @FindBy(xpath = "//*[@id='menu-item-1074']")
    public WebElement myaccaunt;
    @FindBy(xpath = "//*[@class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--wcfm-store-manager']")
    public WebElement stromanager;
    @FindBy(xpath = "(//*[@class='text'])[4]")
    public WebElement product;
    @FindBy(xpath = "(//*[@class='text'])[18]")
    public WebElement newadd;
    @FindBy(xpath = "//*[@class='wcfmfa fa-arrow-alt-circle-right block-indicator']")
    public WebElement invatid;
    @FindBy(xpath ="//*[@id=\"wcfm_products_manage_form_toptan-urun-gosterme-ayarlari_head\"]/div")
    public WebElement toptanurun;
    @FindBy(xpath = "//*[@class='piecetype wcfm_title field_61d331d8dc5a9']")
    public WebElement PieceType;
    @FindBy(xpath = "//*[@id='unitpercart']")
    public WebElement UnitsPerPiece;
    @FindBy(xpath = "//*[@class='minorderqtytr wcfm_title field_61d33a93da83d']")
    public WebElement MInOrderQuantity;
    @FindBy(xpath ="//*[@class='wcfm_menu_item active']")
    public WebElement home;
    @FindBy(xpath ="//*[@id='wcfm-coupons_wrapper']")
    public WebElement urunlistesi;
    @FindBy(xpath ="//*[@id='wcfm-orders']")
    public WebElement Ordertable;
    @FindBy(xpath = "//*[@class='wcfm_menu_item active']")
    public WebElement Orders;
    @FindBy(xpath ="//*[@class='btn btn-dark btn-rounded btn-icon-right continue-shopping mb-4 mt-6']")
    public WebElement goshop;
    @FindBy(xpath ="//*[@class='woocommerce-button woocommerce-button--previous woocommerce-Button woocommerce-Button--previous button btn btn-primary btn-md']")
    public WebElement previus;
    @FindBy(xpath ="//*[@class='woocommerce-button woocommerce-button--next woocommerce-Button woocommerce-Button--next button btn btn-primary btn-md']")
    public WebElement next;
    @FindBy(xpath ="//*[@class='woocommerce-orders-table woocommerce-MyAccount-orders shop_table shop_table_responsive my_account_orders account-orders-table']")
    public WebElement Ordersbasligi;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div/div/table/thead/tr/th[1]")
    public WebElement Order;
    @FindBy(xpath = "//*[@class='wcfm_menu_item active']")
    public WebElement coupons1;
    @FindBy(xpath = "//*[@id='dropdown_shop_coupon_type']")
    public WebElement showalltype;
    @FindBy(xpath ="(//*[@class='text-uppercase text-center mb-0'])[3]")
    public WebElement Adress;
    @FindBy(xpath ="//*[@class='woocommerce-MyAccount-content col-md-9 pt-2']")
    public WebElement Billingveshipping;
    @FindBy(xpath ="//*[@id='user_email']")
    public WebElement Email;
    @FindBy(xpath ="//*[@class='wcfm_menu_items wcfm_menu_wcfm-customers']")
    public WebElement Customer;
    @FindBy(xpath ="//*[@id=\"wcfm-content\"]/div[2]/div[2]/div[2]/h2")
    public WebElement edit;
    @FindBy(xpath ="(//*[@class='wcfmfa fa-edit text_tip'])[1]")
    public WebElement editcustomerbutton;









    //US 13-14-15 Melek (350-399)

    @FindBy(xpath = "//*[@class='wcfmfa fa-gift']")
    public WebElement coupons;
    @FindBy(xpath = "//*[@class='wcfm_sub_menu_items wcfm_sub_menu_items_coupon_manage moz_class']")
    public WebElement AddNew;
    @FindBy(xpath = "//input[@value='12344321']")
    public WebElement code;
    @FindBy(xpath = "//*[@class='wcfm-textarea wcfm_ele']")
    public WebElement Description;
    @FindBy(xpath = "//select[@id='discount_type']")
    public WebElement DiscountType;
    @FindBy(xpath = "//input[@id='coupon_amount']")
    public WebElement CouponAmount;
    @FindBy(xpath = "//input[@id='expiry_date']")
    public WebElement CouponExpirydate;
    @FindBy(xpath = "//input[@id='free_shipping']")
    public WebElement AllowFreeshipping;
    @FindBy(xpath = "//input[@id='show_on_store']")
    public WebElement ShowOnstore;
    @FindBy(xpath = "//input[@id='minimum_amount']")
    public WebElement minInput;
    @FindBy(xpath = "//input[@id='maximum_amount']")
    public WebElement maxInput;
    @FindBy(xpath = "//input[@id='individual_use']")
    public WebElement IndividualUseonly;
    @FindBy(xpath = "//input[@id='exclude_sale_items']")
    public WebElement ExcludeSaleitems;
    @FindBy(xpath = "(//input[@style='width: 447.781px;'])[4]")
    public WebElement ExcludeCategories;
    @FindBy(xpath = "//input[@id='customer_email']")
    public WebElement EmailRestrictions;
    @FindBy(xpath = "//*[@id='coupons_manage_limit']")
    public WebElement Limit;
    @FindBy(xpath = "//input[@id='wcfm_coupon_manager_submit_button']")
    public WebElement submit1;
    @FindBy(xpath = "//input[@id='usage_limit']")
    public WebElement UsageLimit;
    @FindBy(xpath = "//input[@id='limit_usage_to_x_items']")
    public WebElement UsagetoXitems;
    @FindBy(xpath = "//input[@id='usage_limit_per_user']")
    public  WebElement UsagelimitPerUser;








    //US 16-17-18 HAKAN (400-449)
    @FindBy(xpath = "//*[@class='wcfmfa fa-user-circle']")
    public WebElement customers;
    @FindBy(xpath = "//*[@class='wcfmfa fa-user-plus']")
    public WebElement customers_AddNew;
    @FindBy(css = "#user_name")
    public WebElement customers_Username;
    @FindBy(css = "#user_email")
    public WebElement customers_Email;
    @FindBy(css = "#first_name")
    public WebElement customers_FirstName;
    @FindBy(css = "#last_name")
    public WebElement customers_LastName;
    @FindBy(css = "#wcfm_customer_submit_button")
    public WebElement customers_Submit;
    @FindBy(xpath = "//input[@type='search'and @aria-controls='wcfm-shop-customers']")
    public WebElement customers_Search;
    @FindBy(xpath = "//tbody/tr/td[2]")
    public WebElement customers_SearchResult;
    @FindBy(xpath = "//tbody/tr/td[1]")
    public List<WebElement> customers_Names;
    @FindBy(xpath = "//tbody/tr/td[2]")
    public List<WebElement> customers_UserNames;
    @FindBy(xpath = "//tbody/tr/td[3]")
    public List<WebElement> customers_Emails;
    @FindBy(xpath = "//tbody/tr/td[4]")
    public List<WebElement> customers_Locations;
    @FindBy(xpath = "//tbody/tr/td[6]")
    public List<WebElement> customers_MoneySpents;
    @FindBy(xpath = "//tbody/tr/td[7]")
    public List<WebElement> customers_LastOrders;
    @FindBy(xpath = "//span[.='PDF']")
    public WebElement customers_PDF;
    @FindBy(xpath = "//span[.='Excel']")
    public WebElement customers_Excel;
    @FindBy(xpath = "//span[.='CSV']")
    public WebElement customers_CSV;
    @FindBy(css = "#bfirst_name")
    public WebElement customers_BillingFirstName;
    @FindBy(xpath = "//*[contains(text(),'Customer Successfully Saved.')]")
    public WebElement customers_add;
    @FindBy(css = "#bcountry")
    public WebElement customers_Country;
    @FindBy(css = "#same_as_billing")
    public WebElement customers_Same_as_billing;
    @FindBy(css = "#sfirst_name")
    public WebElement customers_shippingFirstName;
    @FindBy(xpath = "//*[@class='wcfmfa fa-retweet']")
    public WebElement refund;
    @FindBy(xpath = "//tbody/tr/td[5]")    public List<WebElement> refund_Type;
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
    @FindBy(id="featured_img_display")
    public WebElement clickBigPhoto;
    @FindBy(xpath="(//*[@class='attachment-preview js--select-attachment type-image subtype-png portrait'])[4]")
    public WebElement chooseBigPhoto;
    @FindBy(xpath="//button[text()='Select']")
    public WebElement selectBigPhoto;
    @FindBy(xpath="//input[@id='sold_individually']")
    public WebElement soldIndividually;



























}
