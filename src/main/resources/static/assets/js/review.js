const reviewTable = document.querySelector('#reviewList')

fetch('/place/reviewlist') 
  .then(response => response.json()) 
  .then(reviewlist => {
    if (reviewlist && Array.isArray(reviewlist)) { // check if planlist is not undefined and is an array
      reviewlist.forEach(review => {
        const row = document.createElement("tr"); 
        row.innerHTML = `
          <td>${review.user_id}</td>
          <td>${review.title}</td>
          <td>${review.user_review}</td>
          <td>${review.register_time}</td>
        `;
        reviewTable.appendChild(row); 
      });
    } else {
      console.error('Invalid response from server:', reviewlist);
    }
  })
  .catch(error => console.error(error));