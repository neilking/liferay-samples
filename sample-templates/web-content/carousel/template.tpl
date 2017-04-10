<style>
	#carousel-<@portlet.namespace /> .aspect-ratio-custom {
		padding-bottom: ${aspectRatio.getData()};
	}
	
	@media (max-width: 799px) {
	#carousel-<@portlet.namespace /> .aspect-ratio-custom {
		padding-bottom: 67%;
	}
	}
	
</style>


<#if image.getSiblings()?has_content>
	<section class="carousel-container">
		<div class="carousel slide" data-ride="carousel" id='carousel-<@portlet.namespace />'>
			<ol class="carousel-indicators hidden-sm hidden-xs">
				<#list image.getSiblings() as cur_img>
					<li class="${(cur_img?counter == 1)?then('active', '')}" data-slide-to="${(cur_img?counter == 1)?then(0, (cur_img?counter - 1))}" data-target='carousel-<@portlet.namespace />'></li>
				</#list>
			</ol>

			<div class="carousel-inner" role="listbox">
				<#list image.getSiblings() as cur_innerImage>
					<div class="${(cur_innerImage?counter == 1)?then('active', '')} item">
						<div class="aspect-ratio aspect-ratio-custom aspect-ratio-middle">
							 <img alt="${cur_innerImage.getAttribute("alt")}" src="${cur_innerImage.getData()}">
						</div>
					</div>
				</#list>
			</div>

			<a class="left carousel-control" href='#carousel-<@portlet.namespace />' role="button" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>

				<span class="sr-only">Previous</span>
			</a>

			<a class="right carousel-control" href='#carousel-<@portlet.namespace />' role="button" data-slide="next">
				<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>

				<span class="sr-only">Next</span>
			</a>
		</div>
	</section>
</#if>