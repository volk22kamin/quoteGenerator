const quoteContainer = document.getElementById('quoteContainer');
const quoteText = document.getElementById('quote');
const authorName = document.getElementById('author');
const twitterBtn = document.getElementById('twitter');
const newQuoteBtn = document.getElementById('newQuote');
const loader = document.getElementById('loader');




let apiQuotes = [];

function showLoadingSpinner(){
    loader.hidden = false;
    quoteContainer.hidden = true;
}

function removeLoadingSpinner(){
    quoteContainer.hidden = false; 
    loader.hidden = true;
}


// new quote
function newQuote(){
    showLoadingSpinner();
    const quote = apiQuotes[Math.floor(Math.random() * apiQuotes.length)];
    if(!quote.author){
        authorName.textContent = 'Unknown';
    } else {
        authorName.textContent = quote.author;
    }
    if(quote.text.length > 120){
        quoteText.classList.add('longQuote');
    } else{
        quoteText.classList.remove('longQuote');
    }
    quoteText.textContent = quote.text;
    removeLoadingSpinner();
}

async function getQuotesFromAPI(){
    showLoadingSpinner();
    const apiURL = 'https://type.fit/api/quotes';
    try{
        const response = await fetch(apiURL);
        apiQuotes = await response.json(); 
        newQuote();
    } catch(error){
        // catch error here 

    }
}

// tweet the quote
function tweetQuote(){
    const twitterURL = `https://twitter.com/intent/tweet?text=${quoteText.textContent} - ${authorName.textContent}`;
    window.open(twitterURL, '_blank');
}


// event listeners
newQuoteBtn.addEventListener('click', newQuote)
twitterBtn.addEventListener('click', tweetQuote);


// on load
getQuotesFromAPI();