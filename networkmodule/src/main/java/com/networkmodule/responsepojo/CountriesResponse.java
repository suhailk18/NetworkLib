package com.networkmodule.responsepojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CountriesResponse {


	/**
	 * name : Colombia
	 * topLevelDomain : [".co"]
	 * alpha2Code : CO
	 * alpha3Code : COL
	 * callingCodes : ["57"]
	 * capital : Bogotá
	 * altSpellings : ["CO","Republic of Colombia","República de Colombia"]
	 * region : Americas
	 * subregion : South America
	 * population : 48759958
	 * latlng : [4,-72]
	 * demonym : Colombian
	 * area : 1141748
	 * gini : 55.9
	 * timezones : ["UTC-05:00"]
	 * borders : ["BRA","ECU","PAN","PER","VEN"]
	 * nativeName : Colombia
	 * numericCode : 170
	 * currencies : [{"code":"COP","name":"Colombian peso","symbol":"$"}]
	 * languages : [{"iso639_1":"es","iso639_2":"spa","name":"Spanish","nativeName":"Español"}]
	 * translations : {"de":"Kolumbien","es":"Colombia","fr":"Colombie","ja":"コロンビア","it":"Colombia","br":"Colômbia","pt":"Colômbia","nl":"Colombia","hr":"Kolumbija","fa":"کلمبیا"}
	 * flag : https://restcountries.eu/data/col.svg
	 * regionalBlocs : [{"acronym":"PA","name":"Pacific Alliance","otherAcronyms":[],"otherNames":["Alianza del Pacífico"]},{"acronym":"USAN","name":"Union of South American Nations","otherAcronyms":["UNASUR","UNASUL","UZAN"],"otherNames":["Unión de Naciones Suramericanas","União de Nações Sul-Americanas","Unie van Zuid-Amerikaanse Naties","South American Union"]}]
	 * cioc : COL
	 */

	@SerializedName("name")
	private String name;
	@SerializedName("alpha2Code")
	private String alpha2Code;
	@SerializedName("alpha3Code")
	private String alpha3Code;
	@SerializedName("capital")
	private String capital;
	@SerializedName("region")
	private String region;
	@SerializedName("subregion")
	private String subregion;
	@SerializedName("population")
	private int population;
	@SerializedName("demonym")
	private String demonym;
	@SerializedName("area")
	private int area;
	@SerializedName("gini")
	private double gini;
	@SerializedName("nativeName")
	private String nativeName;
	@SerializedName("numericCode")
	private String numericCode;
	@SerializedName("translations")
	private TranslationsBean translations;
	@SerializedName("flag")
	private String flag;
	@SerializedName("cioc")
	private String cioc;
	@SerializedName("topLevelDomain")
	private List<String> topLevelDomain;
	@SerializedName("callingCodes")
	private List<String> callingCodes;
	@SerializedName("altSpellings")
	private List<String> altSpellings;
	@SerializedName("latlng")
	private List<Integer> latlng;
	@SerializedName("timezones")
	private List<String> timezones;
	@SerializedName("borders")
	private List<String> borders;
	@SerializedName("currencies")
	private List<CurrenciesBean> currencies;
	@SerializedName("languages")
	private List<LanguagesBean> languages;
	@SerializedName("regionalBlocs")
	private List<RegionalBlocsBean> regionalBlocs;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlpha2Code() {
		return alpha2Code;
	}

	public void setAlpha2Code(String alpha2Code) {
		this.alpha2Code = alpha2Code;
	}

	public String getAlpha3Code() {
		return alpha3Code;
	}

	public void setAlpha3Code(String alpha3Code) {
		this.alpha3Code = alpha3Code;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getSubregion() {
		return subregion;
	}

	public void setSubregion(String subregion) {
		this.subregion = subregion;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public String getDemonym() {
		return demonym;
	}

	public void setDemonym(String demonym) {
		this.demonym = demonym;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public double getGini() {
		return gini;
	}

	public void setGini(double gini) {
		this.gini = gini;
	}

	public String getNativeName() {
		return nativeName;
	}

	public void setNativeName(String nativeName) {
		this.nativeName = nativeName;
	}

	public String getNumericCode() {
		return numericCode;
	}

	public void setNumericCode(String numericCode) {
		this.numericCode = numericCode;
	}

	public TranslationsBean getTranslations() {
		return translations;
	}

	public void setTranslations(TranslationsBean translations) {
		this.translations = translations;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getCioc() {
		return cioc;
	}

	public void setCioc(String cioc) {
		this.cioc = cioc;
	}

	public List<String> getTopLevelDomain() {
		return topLevelDomain;
	}

	public void setTopLevelDomain(List<String> topLevelDomain) {
		this.topLevelDomain = topLevelDomain;
	}

	public List<String> getCallingCodes() {
		return callingCodes;
	}

	public void setCallingCodes(List<String> callingCodes) {
		this.callingCodes = callingCodes;
	}

	public List<String> getAltSpellings() {
		return altSpellings;
	}

	public void setAltSpellings(List<String> altSpellings) {
		this.altSpellings = altSpellings;
	}

	public List<Integer> getLatlng() {
		return latlng;
	}

	public void setLatlng(List<Integer> latlng) {
		this.latlng = latlng;
	}

	public List<String> getTimezones() {
		return timezones;
	}

	public void setTimezones(List<String> timezones) {
		this.timezones = timezones;
	}

	public List<String> getBorders() {
		return borders;
	}

	public void setBorders(List<String> borders) {
		this.borders = borders;
	}

	public List<CurrenciesBean> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(List<CurrenciesBean> currencies) {
		this.currencies = currencies;
	}

	public List<LanguagesBean> getLanguages() {
		return languages;
	}

	public void setLanguages(List<LanguagesBean> languages) {
		this.languages = languages;
	}

	public List<RegionalBlocsBean> getRegionalBlocs() {
		return regionalBlocs;
	}

	public void setRegionalBlocs(List<RegionalBlocsBean> regionalBlocs) {
		this.regionalBlocs = regionalBlocs;
	}

	public static class TranslationsBean {
		/**
		 * de : Kolumbien
		 * es : Colombia
		 * fr : Colombie
		 * ja : コロンビア
		 * it : Colombia
		 * br : Colômbia
		 * pt : Colômbia
		 * nl : Colombia
		 * hr : Kolumbija
		 * fa : کلمبیا
		 */

		@SerializedName("de")
		private String de;
		@SerializedName("es")
		private String es;
		@SerializedName("fr")
		private String fr;
		@SerializedName("ja")
		private String ja;
		@SerializedName("it")
		private String it;
		@SerializedName("br")
		private String br;
		@SerializedName("pt")
		private String pt;
		@SerializedName("nl")
		private String nl;
		@SerializedName("hr")
		private String hr;
		@SerializedName("fa")
		private String fa;

		public String getDe() {
			return de;
		}

		public void setDe(String de) {
			this.de = de;
		}

		public String getEs() {
			return es;
		}

		public void setEs(String es) {
			this.es = es;
		}

		public String getFr() {
			return fr;
		}

		public void setFr(String fr) {
			this.fr = fr;
		}

		public String getJa() {
			return ja;
		}

		public void setJa(String ja) {
			this.ja = ja;
		}

		public String getIt() {
			return it;
		}

		public void setIt(String it) {
			this.it = it;
		}

		public String getBr() {
			return br;
		}

		public void setBr(String br) {
			this.br = br;
		}

		public String getPt() {
			return pt;
		}

		public void setPt(String pt) {
			this.pt = pt;
		}

		public String getNl() {
			return nl;
		}

		public void setNl(String nl) {
			this.nl = nl;
		}

		public String getHr() {
			return hr;
		}

		public void setHr(String hr) {
			this.hr = hr;
		}

		public String getFa() {
			return fa;
		}

		public void setFa(String fa) {
			this.fa = fa;
		}
	}

	public static class CurrenciesBean {
		/**
		 * code : COP
		 * name : Colombian peso
		 * symbol : $
		 */

		@SerializedName("code")
		private String code;
		@SerializedName("name")
		private String name;
		@SerializedName("symbol")
		private String symbol;

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSymbol() {
			return symbol;
		}

		public void setSymbol(String symbol) {
			this.symbol = symbol;
		}
	}

	public static class LanguagesBean {
		/**
		 * iso639_1 : es
		 * iso639_2 : spa
		 * name : Spanish
		 * nativeName : Español
		 */

		@SerializedName("iso639_1")
		private String iso6391;
		@SerializedName("iso639_2")
		private String iso6392;
		@SerializedName("name")
		private String name;
		@SerializedName("nativeName")
		private String nativeName;

		public String getIso6391() {
			return iso6391;
		}

		public void setIso6391(String iso6391) {
			this.iso6391 = iso6391;
		}

		public String getIso6392() {
			return iso6392;
		}

		public void setIso6392(String iso6392) {
			this.iso6392 = iso6392;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getNativeName() {
			return nativeName;
		}

		public void setNativeName(String nativeName) {
			this.nativeName = nativeName;
		}
	}

	public static class RegionalBlocsBean {
		/**
		 * acronym : PA
		 * name : Pacific Alliance
		 * otherAcronyms : []
		 * otherNames : ["Alianza del Pacífico"]
		 */

		@SerializedName("acronym")
		private String acronym;
		@SerializedName("name")
		private String name;
		@SerializedName("otherAcronyms")
		private List<?> otherAcronyms;
		@SerializedName("otherNames")
		private List<String> otherNames;

		public String getAcronym() {
			return acronym;
		}

		public void setAcronym(String acronym) {
			this.acronym = acronym;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<?> getOtherAcronyms() {
			return otherAcronyms;
		}

		public void setOtherAcronyms(List<?> otherAcronyms) {
			this.otherAcronyms = otherAcronyms;
		}

		public List<String> getOtherNames() {
			return otherNames;
		}

		public void setOtherNames(List<String> otherNames) {
			this.otherNames = otherNames;
		}
	}
}
