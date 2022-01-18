import PropTypes from "prop-types"

function Movie({mediumCoverImage, title, summary, genres}) {
  return (
  <div>
  <img src={mediumCoverImage} alt={title}></img>
  <h2>{title}</h2>
  <p>{summary}</p>
  <ul>
    {genres.map((g) => (<li key={g}>{g}</li>))}
  </ul>
</div>
)}

Movie.propTypes = {
  mediumCoverImage: PropTypes.string.isRequired,
  title: PropTypes.string.isRequired,
  summary: PropTypes.string.isRequired,
  genres: PropTypes.arrayOf(PropTypes.string).isRequired
}

export default Movie;