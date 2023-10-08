let aTags = document.querySelectorAll('.projectContainer');

aTags.forEach((aTag)=>{
    aTag.addEventListener('mouseover', (e)=>{
        e.preventDefault();
        e.target.classList.add('isHovered');
    });
    aTag.addEventListener('mouseout', (e)=>{
        e.target.classList.remove('isHovered');
    })
    
})