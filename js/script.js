const quoteContainer = document.getElementById('quoteContainer');
const quoteText = document.getElementById('quote');
const authorName = document.getElementById('author');
const twitterBtn = document.getElementById('twitter');
const newQuoteBtn = document.getElementById('newQuote');




let apiQuotes = [];


// new quote
function newQuote(){
    const quote = apiQuotes[Math.floor(Math.random() * apiQuotes.length)];
    // check if author nae is blank and replace with 'unknown'
    if(!quote.author){
        authorName.textContent = 'Unknown';
    } else {
        authorName.textContent = quote.author;
    }
    // if the quote is too long
    if(quote.text.length > 120){
        quoteText.classList.add('longQuote');
    } else{
        quoteText.classList.remove('longQuote');
    }
    quoteText.textContent = quote.text;
}
// get quotes from API
async function getQuotes(){
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
    const twitterURL = `https://twitter.com/intent/tweet?text=${quoteText.textContent} - ${authorName.text}`;
    window.open(twitterURL, '_blank');
}


// event listeners
newQuoteBtn.addEventListener('click', newQuote)
twitterBtn.addEventListener('click', tweetQuote);


// on load
getQuotes();