walk(document.body);

function walk(node) 
{
	// I stole this function from here:
	// http://is.gd/mwZp7E
	
	var child, next;
	
	var tagName = node.tagName ? node.tagName.toLowerCase() : "";
	if (tagName == 'input' || tagName == 'textarea') {
		return;
	}
	if (node.classList && node.classList.contains('ace_editor')) {
		return;
	}

	switch ( node.nodeType )  
	{
		case 1:  // Element
		case 9:  // Document
		case 11: // Document fragment
			child = node.firstChild;
			while ( child ) 
			{
				next = child.nextSibling;
				walk(child);
				child = next;
			}
			break;

		case 3: // Text node
			handleText(node);
			break;
	}
}

function handleText(textNode) 
{
	var v = textNode.nodeValue;

	v = v.replace(/\bChina/g, "West Taiwan");
	v = v.replace(/\bchina/g, "west taiwan");
	v = v.replace(/\bChinese/g, "West Taiwanese");
	v = v.replace(/\bchinese/g, "west taiwanese");
	v = v.replace(/\bCHINA/g, "WEST TAIWAN");
	v = v.replace(/\bCHINESE/g, "WEST TAIWANESE");
	v = v.replace(/\ichinese/g, "West Taiwanese");
	v = v.replace(/\ichina/g, "West Taiwan");
	
	textNode.nodeValue = v;
}

