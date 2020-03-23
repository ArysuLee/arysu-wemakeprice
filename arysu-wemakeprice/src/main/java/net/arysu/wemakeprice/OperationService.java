package net.arysu.wemakeprice;

import org.springframework.stereotype.Service;

@Service
public class OperationService {

	private WebScraper scraper;
	private CharacterSorter sorter;
	private StringBundler bundler;

	public OperationService(WebScraper scraper, CharacterSorter sorter, StringBundler bundler) {
		this.scraper = scraper;
		this.sorter = sorter;
		this.bundler = bundler;
	}

	public StringBundle operateCharacter(String url, boolean excludeTag, int bundleCount) {

		ByteHolder holder = scraper.scrap(url, excludeTag);
		String text = sorter.sort(holder);
		StringBundle bundle = bundler.createBundle(text, bundleCount);

		return bundle;
	}
}
